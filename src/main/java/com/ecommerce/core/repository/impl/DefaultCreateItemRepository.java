package com.ecommerce.core.repository.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.repository.CreateItemRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultCreateItemRepository implements CreateItemRepository {

    @Autowired
    MemoryDB memoryDB;

    @Override
    public Optional<Item> get(@NonNull Item item) {
        return memoryDB.save(item);
    }
}
