package lk.ijse.absd.service;

import lk.ijse.absd.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(String customerId, CustomerDTO dto);

    void updateCustomer(String customerId, CustomerDTO dto);

    void deleteCustomer(String customerId);

    CustomerDTO findCustomer(String customerId);

    List<CustomerDTO> findAllCustomers();

    List<CustomerDTO> findCustomersLike(String name);

    long getCustomersCount();

}
