package com.ecommerce.core.repository;

import lombok.NonNull;

@FunctionalInterface
public interface DeleteItemRepository {
    void execute(@NonNull Long itemId);
}
