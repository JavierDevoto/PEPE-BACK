package com.ecommerce.core.repository.impl;

import com.ecommerce.core.domain.DomainItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface H2Implementation extends CrudRepository<DomainItem, Long> {
    Page<DomainItem> findAll(Pageable pageable);

    @Query(
            value = "select i.* from items i" +
                    " where (title ilike %:search%" +
                    "    or subtitle ilike %:search%)" +
                    " limit :limit " +
                    "offset :offset",
            nativeQuery = true
    )
    List<DomainItem> search(Long limit, Long offset, String search);
}
