package com.ecommerce.core.repository.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.repository.RetrieveItemRepository;
import com.ecommerce.core.repository.mappers.MapDomainItemToItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultRetrieveItemRepository implements RetrieveItemRepository {

    @Autowired
    H2Implementation h2Implementation;

    @Autowired
    MapDomainItemToItem mapDomainItemToItem;

    @Override
    public Optional<Item> get(@NonNull Long itemId) {
        return h2Implementation.findById(itemId)
                .map(domainItem -> mapDomainItemToItem.get(domainItem));
    }
}
