package com.ecommerce.route.controller;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.paging.PagedResult;
import com.ecommerce.core.usecase.CreateItem;
import com.ecommerce.core.usecase.RetrieveItem;
import com.ecommerce.core.usecase.SearchItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    RetrieveItem retrieveItem;

    @Autowired
    CreateItem createItem;

    @Autowired
    SearchItems searchItems;

    @GetMapping(value = "/items/{id}")
    public Item getItem(
            @PathVariable Long id
    ) {
        return retrieveItem.get(id);
    }

    @GetMapping(value = "/items/search")
    public PagedResult<Item> findItems(
            @RequestParam(defaultValue = "20") Long limit,
            @RequestParam(defaultValue = "0") Long offset,
            @RequestParam String search,
            @RequestParam String tag,
            @RequestParam String sort
    ) {
        return searchItems.get(limit, offset, search, tag, sort);
    }

    @PostMapping(value = "/items")
    public Item saveItem(
            @RequestBody Item item
    ) {
        return createItem.get(item);
    }
}
