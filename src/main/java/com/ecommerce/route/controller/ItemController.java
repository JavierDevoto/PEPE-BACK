package com.ecommerce.route.controller;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.usecase.CreateItem;
import com.ecommerce.core.usecase.RetrieveItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    RetrieveItem retrieveItem;

    @Autowired
    CreateItem createItem;

    @GetMapping(value = "/items/{id}")
    public Item getItem(@PathVariable Long id) {
        return retrieveItem.get(id);
    }

    @PostMapping(value = "/items")
    public Item saveItem(@RequestBody Item item) {
        return createItem.get(item);
    }
}
