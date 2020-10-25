package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.paging.PagedResult;
import com.ecommerce.core.repository.SearchItemsRepository;
import com.ecommerce.core.usecase.SearchItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSearchItems implements SearchItems {

    @Autowired
    SearchItemsRepository searchItemsRepository;

    @Override
    public PagedResult<Item> get(Long limit, Long offset, String search, String tag, String sort) {
        return searchItemsRepository.get(limit, offset, search, tag, sort);
    }
}
