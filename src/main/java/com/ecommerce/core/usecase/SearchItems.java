package com.ecommerce.core.usecase;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.paging.PagedResult;

@FunctionalInterface
public interface SearchItems {
    PagedResult<Item> get(Long limit, Long offset, String search, String tag, String sort);
}
