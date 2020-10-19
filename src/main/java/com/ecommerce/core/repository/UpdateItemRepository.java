package com.ecommerce.core.repository;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;

@FunctionalInterface
public interface UpdateItemRepository {
    void execute(@NonNull Item item);
}
