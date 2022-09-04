package com.velov.shop.shopapp.service;

import com.velov.shop.shopapp.dao.ItemDAO;
import com.velov.shop.shopapp.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDAO itemDAO;

    @Override
    @Transactional
    public List<Item> getAllItems() {

        return itemDAO.getAllItems();
    }
}
