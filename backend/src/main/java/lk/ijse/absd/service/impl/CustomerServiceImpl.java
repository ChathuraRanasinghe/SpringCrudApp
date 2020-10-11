package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.entity.Customer;
import lk.ijse.absd.repository.CustomerRepository;
import lk.ijse.absd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveCustomer(String customerId, CustomerDTO dto) {
        if (!dto.getId().equals(customerId)) {
            throw new RuntimeException("Customer ID mismatched");
        }
        repository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateCustomer(String customerId, CustomerDTO dto) {
        if (!dto.getId().equals(customerId)) {
            throw new RuntimeException("Customer ID mismatched");
        }
        if (repository.existsById(customerId)) {
            repository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
        }else{
            throw new RuntimeException("Customer doesn't exist");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);

    }

    @Override
    public CustomerDTO findCustomer(String customerId) {
        Customer customer = repository.findById(customerId).get();
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> allCustomers = repository.findAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        allCustomers.forEach(c -> dtos.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress())));
        return dtos;
    }

    @Override
    public List<CustomerDTO> findCustomersLike(String name) {
        List<Customer> allCustomers =  repository.letsFindSomeCustomers(name + "%");
        List<CustomerDTO> dtos = new ArrayList<>();
        allCustomers.forEach(c -> dtos.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress())));
        return dtos;
    }

    @Override
    public long getCustomersCount() {
        return  repository.count();
    }
}
