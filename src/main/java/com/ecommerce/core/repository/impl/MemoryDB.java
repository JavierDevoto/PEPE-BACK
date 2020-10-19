package com.ecommerce.core.repository.impl;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class MemoryDB {

    private final Set<Item> items = new HashSet<>();
    private long currentId = 0;

    public Optional<Item> get(@NonNull Long itemId) {
        return items.stream()
                .filter(item -> itemId.equals(item.getId()))
                .findFirst();
    }

    public Optional<Item> save(@NonNull Item item) {
        item.setId(getNext())
                .setDateCreated(LocalDateTime.now())
                .setLastUpdated(LocalDateTime.now());
        items.add(item);
        return Optional.of(item);
    }

    private long getNext() {
        return ++currentId;
    }
}
