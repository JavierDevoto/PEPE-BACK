package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.repository.SearchItemsRepository;
import com.ecommerce.core.usecase.SearchItems;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DefaultSearchItems implements SearchItems {

    @Autowired
    SearchItemsRepository searchItemsRepository;

    @Override
    public Page<Item> get(@NonNull Pageable pageable) {
        return searchItemsRepository.get(pageable);
    }
}
