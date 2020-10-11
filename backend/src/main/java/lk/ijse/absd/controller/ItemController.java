package lk.ijse.absd.controller;


import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.service.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemServices services;

    @PutMapping("/{code}")
    public void saveCustomer(@PathVariable("code") String code,
                             @RequestBody ItemDTO itemDTO) {

        services.saveItems(code, itemDTO);

    }

}
