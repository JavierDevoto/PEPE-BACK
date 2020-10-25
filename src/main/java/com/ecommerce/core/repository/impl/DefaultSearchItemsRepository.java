package com.ecommerce.core.repository.impl;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.paging.PagedResult;
import com.ecommerce.core.dto.paging.Paging;
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

    private List<Item> mapToItem(Stream<DomainItem> domainItemStream) {
        return domainItemStream.map(domainItem -> mapDomainItemToItem.get(domainItem))
                .collect(Collectors.toList());
    }

    @Override
    public PagedResult<Item> get(Long limit, Long offset, String search, String tag, String sort) {
        List<DomainItem> items = h2Implementation.search(limit, offset, search);

        return new PagedResult<Item>()
                .setResults(mapToItem(items.stream()))
                .setPaging(new Paging()
                        .setLimit(limit)
                        .setOffset(offset)
                        .setTotal(1));
    }
}
