package com.ecommerce.core.repository.mappers;

import com.ecommerce.core.domain.DomainItemVariant;
import com.ecommerce.core.dto.ItemVariant;
import lombok.NonNull;

@FunctionalInterface
public interface MapItemVariantToDomainItemVariant {
    DomainItemVariant get(@NonNull ItemVariant itemVariant);
}
