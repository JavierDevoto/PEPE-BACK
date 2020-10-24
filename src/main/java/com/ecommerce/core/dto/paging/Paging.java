package com.ecommerce.core.dto.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Paging {
    private long limit;
    private long offset;
    private long total;
}
