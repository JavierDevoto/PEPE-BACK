package com.ecommerce.core.repository.mappers;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.dto.Item;
import lombok.NonNull;

@FunctionalInterface
public interface MapItemToDomainItem {
    DomainItem get(@NonNull Item item);
}
