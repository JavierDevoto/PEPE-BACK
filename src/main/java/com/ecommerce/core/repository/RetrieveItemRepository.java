package com.ecommerce.core.repository;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;

import java.util.Optional;

@FunctionalInterface
public interface RetrieveItemRepository {
    Optional<Item> get(@NonNull Long itemId);
}
