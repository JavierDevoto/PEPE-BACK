package com.ecommerce.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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

    public Optional<ItemVariant> findVariant(@NonNull Long id) {
        if (isNull(variants)) {
            return Optional.empty();
        }
        return variants.stream()
                .filter(itemVariant -> id.equals(itemVariant.getId()))
                .findFirst();
    }

    public Optional<ItemAttribute> findAttribute(@NonNull AttributeType attributeType) {
        if (isNull(attributes)) {
            return Optional.empty();
        }
        return attributes.stream()
                .filter(itemAttribute -> attributeType.equals(itemAttribute.getType()))
                .findFirst();
    }

    @JsonIgnore
    public boolean isVariantItem() {
        return nonNull(variants) && !variants.isEmpty();
    }
}
