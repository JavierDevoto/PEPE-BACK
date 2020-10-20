package com.ecommerce.core.repository.impl;

import com.ecommerce.core.domain.DomainItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface H2Implementation extends CrudRepository<DomainItem, Long> {

    //Page<DomainItem> findByItemTag(String itemTag, Pageable pageable);

    Page<DomainItem> findAll(Pageable pageable);
}
