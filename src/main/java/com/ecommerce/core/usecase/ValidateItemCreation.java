package com.ecommerce.core.usecase;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;

@FunctionalInterface
public interface ValidateItemCreation {
    void execute(@NonNull Item item);
}
