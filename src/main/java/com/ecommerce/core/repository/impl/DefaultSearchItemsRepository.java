package com.ecommerce.core.repository.impl;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.dto.Item;
import com.ecommerce.core.repository.SearchItemsRepository;
import com.ecommerce.core.repository.mappers.MapDomainItemToItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class DefaultSearchItemsRepository implements SearchItemsRepository {

    @Autowired
    H2Implementation h2Implementation;

    @Autowired
    MapDomainItemToItem mapDomainItemToItem;

    @Override
    public Page<Item> get(@NonNull Pageable pageable) {
        Page<DomainItem> domainItemPage = h2Implementation.findAll(pageable);

        return new PageImpl<>(mapToItem(domainItemPage.get()));
    }

    private List<Item> mapToItem(Stream<DomainItem> domainItemStream) {
        return domainItemStream.map(domainItem -> mapDomainItemToItem.get(domainItem))
                .collect(Collectors.toList());
    }
}
