package com.ecommerce.core.repository;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;

import java.util.Optional;

@FunctionalInterface
public interface CreateItemRepository {
    Optional<Item> get(@NonNull Item item);
}
