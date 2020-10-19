package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.exceptions.UseCaseException;
import com.ecommerce.core.repository.RetrieveItemRepository;
import com.ecommerce.core.usecase.RetrieveItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultRetrieveItem implements RetrieveItem {

    @Autowired
    RetrieveItemRepository retrieveItemRepository;

    @Override
    public Item get(@NonNull Long itemId) {
        return retrieveItemRepository.get(itemId)
                .orElseThrow(() -> new UseCaseException("Error while retrieving item"));
    }
}
