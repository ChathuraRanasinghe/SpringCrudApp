package lk.ijse.absd.service;

import lk.ijse.absd.dto.ItemDTO;

import java.util.List;

public  interface  ItemServices {

    void saveItems(String itemCode , ItemDTO itemDTO);

    void updateItems(String itemCode , ItemDTO itemDTO);

    void deleteItems(String code);

    ItemDTO findItem(String code);

    List<ItemDTO>findAllItems();

    List<ItemDTO>findCustomerLike(String name);

    long getItemsCount();



}
