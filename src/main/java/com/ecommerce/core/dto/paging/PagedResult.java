package com.ecommerce.core.dto.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class PagedResult<T> {
    private Paging paging;
    private List<T> results;
}
