package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.exceptions.UseCaseException;
import com.ecommerce.core.repository.CreateItemRepository;
import com.ecommerce.core.usecase.CreateItem;
import com.ecommerce.core.usecase.SetDefaultValuesToItem;
import com.ecommerce.core.usecase.ValidateItemCreation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultCreateItem implements CreateItem {

    @Autowired
    ValidateItemCreation validateItemCreation;

    @Autowired
    SetDefaultValuesToItem setDefaultValuesToItem;

    @Autowired
    CreateItemRepository createItemRepository;

    @Override
    public Item get(@NonNull Item item) {
        validateItemCreation.execute(item);
        return createItemRepository.get(setDefaultValuesToItem.get(item))
                .orElseThrow(() -> new UseCaseException("Error while creating item"));
    }
}
