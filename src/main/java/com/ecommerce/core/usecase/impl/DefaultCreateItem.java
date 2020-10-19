package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.exceptions.UseCaseException;
import com.ecommerce.core.repository.CreateItemRepository;
import com.ecommerce.core.usecase.CreateItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultCreateItem implements CreateItem {

    @Autowired
    CreateItemRepository createItemRepository;

    @Override
    public Item get(@NonNull Item item) {
        return createItemRepository.get(item)
                .orElseThrow(() -> new UseCaseException("Error while creating item"));
    }
}
