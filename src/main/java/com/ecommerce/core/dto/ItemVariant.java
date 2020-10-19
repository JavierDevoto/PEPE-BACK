package com.ecommerce.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class ItemVariant {
    private Long id;
    private BigDecimal price;
    private BigDecimal hardPrice;
    private Long availableQuantity;
    private List<String> smallPictures;
    private List<String> pictures;
    private List<String> videos;
    private List<ItemAttribute> variant;
    private List<ItemAttribute> attributes;
}
