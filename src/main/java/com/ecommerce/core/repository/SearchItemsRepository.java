package com.ecommerce.core.repository;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.paging.PagedResult;

@FunctionalInterface
public interface SearchItemsRepository {
    PagedResult<Item> get(Long limit, Long offset, String search, String tag, String sort);
}
