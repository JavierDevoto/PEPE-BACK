package com.ecommerce.core.dto;

import com.ecommerce.core.dto.paging.PagedResult;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class ItemPagedResult extends PagedResult<Item> {
}
