package com.ecommerce.core.repository.impl;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.dto.Item;
import com.ecommerce.core.repository.CreateItemRepository;
import com.ecommerce.core.repository.mappers.MapDomainItemToItem;
import com.ecommerce.core.repository.mappers.MapItemToDomainItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultCreateItemRepository implements CreateItemRepository {

    @Autowired
    H2Implementation h2Implementation;

    @Autowired
    MapItemToDomainItem mapItemToDomainItem;

    @Autowired
    MapDomainItemToItem mapDomainItemToItem;

    @Override
    public Optional<Item> get(@NonNull Item item) {
        DomainItem domainItem = mapItemToDomainItem.get(item);
        DomainItem savedDomainItem = h2Implementation.save(domainItem);
        return Optional.of(mapDomainItemToItem.get(savedDomainItem));
    }
}
