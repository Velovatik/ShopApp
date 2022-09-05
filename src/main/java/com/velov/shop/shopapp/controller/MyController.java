package com.velov.shop.shopapp.controller;

import com.velov.shop.shopapp.entity.Item;
import com.velov.shop.shopapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/items")
    public Item addNewItem(@RequestBody Item item){

        itemService.saveItem(item);
        return item;
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable int id){
        Item item = itemService.getItem(id);

        return item;
    }

    public String deleteItem(@PathVariable int id){

        itemService.deleteItem(id);
        return "Item ID = " + id + "deleted";
    }
}
