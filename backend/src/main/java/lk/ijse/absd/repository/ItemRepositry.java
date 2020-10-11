package lk.ijse.absd.repository;


import lk.ijse.absd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepositry extends JpaRepository<Item, String> {

    List<Item> LetsFindItems(String code);

}
