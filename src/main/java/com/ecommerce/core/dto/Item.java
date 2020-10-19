package com.ecommerce.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Item {
    private Long id;
    private String title;
    private String subtitle;
    private BigDecimal price;
    private BigDecimal hardPrice;
    private Long availableQuantity;
    private ItemStatus status;
    private List<ItemAttribute> attributes;
    private List<AttributeType> availableVariants;
    private List<ItemVariant> variants;
    private List<String> smallPictures;
    private List<String> pictures;
    private List<String> videos;
    private List<ItemTag> tags;
    private String permalink;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
