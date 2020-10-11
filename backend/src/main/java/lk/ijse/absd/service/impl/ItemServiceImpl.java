package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.repository.ItemRepositry;
import lk.ijse.absd.service.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation=Propagation.SUPPORTS , readOnly = true)


public class ItemServiceImpl implements ItemServices {

    @Autowired
    private ItemRepositry repositry;

    @Transactional(propagation = Propagation.REQUIRED)

    @Override
    public void saveItems(String itemCode, ItemDTO itemDTO) {
        if(!itemDTO.getCode().equals(itemCode)){
            throw new RuntimeException("sorry");
        }
    }

    @Override
    public void updateItems(String itemCode, ItemDTO itemDTO) {

    }

    @Override
    public void deleteItems(String code) {

    }

    @Override
    public ItemDTO findItem(String code) {
        return null;
    }

    @Override
    public List<ItemDTO> findAllItems() {
        return null;
    }

    @Override
    public List<ItemDTO> findCustomerLike(String name) {
        return null;
    }

    @Override
    public long getItemsCount() {
        return 0;
    }
}
