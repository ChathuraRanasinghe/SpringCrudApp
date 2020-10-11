package lk.ijse.absd.controller;

import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PutMapping("/{id}")
    public void saveCustomer(@PathVariable("id") String customerId,
                             @RequestBody CustomerDTO customerDTO) {
        service.saveCustomer(customerId, customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String customerId){
        service.deleteCustomer(customerId);
    }

    @PostMapping("/{id}")
    public void updateCustomer(@PathVariable("id") String customerId,
                               @RequestBody CustomerDTO customerDTO){
        service.updateCustomer(customerId, customerDTO);
    }

    @GetMapping("/{id}")
    public CustomerDTO findCustomer(@PathVariable("id") String customerId){
        return service.findCustomer(customerId);
    }

    @GetMapping
    public Object findAllCustomers(@RequestParam(value = "action", required = false) String action
                ,@RequestParam(value="name", required = false) String name){
        if (action !=null){
            switch (action){
                case "count":
                    return service.getCustomersCount();
                case "like":
                    return service.findCustomersLike(name);
                default:
                    return service.findAllCustomers();
            }
        }else {
            return service.findAllCustomers();
        }
    }


}
