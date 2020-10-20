package com.ecommerce.core.usecase;

import com.ecommerce.core.dto.Item;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface SearchItems {
    Page<Item> get(@NonNull Pageable pageable);
}
