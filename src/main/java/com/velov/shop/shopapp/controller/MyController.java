package com.velov.shop.shopapp.controller;

import com.velov.shop.shopapp.entity.Item;
import com.velov.shop.shopapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class MyController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> showAllItems(){

        List<Item> allItems = itemService.getAllItems();
        return allItems;
    }
}
