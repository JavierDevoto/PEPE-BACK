package com.ecommerce.core.repository.mappers;

import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.dto.ItemAttribute;
import lombok.NonNull;

@FunctionalInterface
public interface MapItemAttributeToDomainItemAttribute {
    DomainItemAttribute get(@NonNull ItemAttribute itemAttribute);
}
