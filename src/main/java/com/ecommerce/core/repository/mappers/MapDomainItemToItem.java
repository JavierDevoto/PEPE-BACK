package com.ecommerce.core.repository.mappers;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.dto.Item;
import lombok.NonNull;

@FunctionalInterface
public interface MapDomainItemToItem {
    Item get(@NonNull DomainItem domainItem);
}
