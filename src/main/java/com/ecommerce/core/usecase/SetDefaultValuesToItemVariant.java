package com.ecommerce.core.usecase;

import com.ecommerce.core.dto.ItemVariant;
import lombok.NonNull;

@FunctionalInterface
public interface SetDefaultValuesToItemVariant {
    ItemVariant get(@NonNull ItemVariant itemVariant);
}
