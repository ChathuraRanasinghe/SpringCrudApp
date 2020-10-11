package lk.ijse.absd.repository;

import lk.ijse.absd.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {

//    List<Customer> findCustomersByNameLike(String name);

    @Query("SELECT c FROM Customer c WHERE c.name LIKE ?#{[0]}")
//    List<Customer> letsFindSomeCustomers(@Param("customerId") String name);
    List<Customer> letsFindSomeCustomers( String name);
}
