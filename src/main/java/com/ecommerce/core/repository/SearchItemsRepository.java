package com.ecommerce.core.repository;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface SearchItemsRepository {
    Page<Item> get(@NonNull Pageable pageable);
}
