package com.ecommerce.core.repository.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.repository.RetrieveItemRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultRetrieveItemRepository implements RetrieveItemRepository {

    @Autowired
    MemoryDB memoryDB;

    @Override
    public Optional<Item> get(@NonNull Long itemId) {
        return memoryDB.get(itemId);
    }
}
