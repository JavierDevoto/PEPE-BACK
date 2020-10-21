package com.ecommerce.core.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

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

    public Optional<ItemAttribute> findAttribute(@NonNull AttributeType attributeType) {
        if (isNull(attributes)) {
            return Optional.empty();
        }
        return attributes.stream()
                .filter(itemAttribute -> attributeType.equals(itemAttribute.getType()))
                .findFirst();
    }

    public Optional<ItemAttribute> findVariant(@NonNull AttributeType attributeType) {
        if (isNull(variant)) {
            return Optional.empty();
        }
        return variant.stream()
                .filter(itemAttribute -> attributeType.equals(itemAttribute.getType()))
                .findFirst();
    }
}
