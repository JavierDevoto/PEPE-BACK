package com.ecommerce.core.usecase;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;

@FunctionalInterface
public interface CreateItem {
    Item get(@NonNull Item item);
}
