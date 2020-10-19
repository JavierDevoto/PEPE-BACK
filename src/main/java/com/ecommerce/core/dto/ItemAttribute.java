package com.ecommerce.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class    ItemAttribute {
    private AttributeType type;
    private String value;
    private String HRValue; //Human Readable Value
}
