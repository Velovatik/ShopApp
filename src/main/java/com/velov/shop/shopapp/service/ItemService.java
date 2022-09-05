package com.velov.shop.shopapp.service;

import com.velov.shop.shopapp.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getAllItems();

    public void saveItem(Item item);

    public Item getItem(int id);

    public void deleteItem(int id);
}
