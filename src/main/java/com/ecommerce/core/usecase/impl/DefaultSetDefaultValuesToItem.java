package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.ItemStatus;
import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.usecase.AdjustPriceValue;
import com.ecommerce.core.usecase.SetDefaultValuesToItem;
import com.ecommerce.core.usecase.SetDefaultValuesToItemVariant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class DefaultSetDefaultValuesToItem implements SetDefaultValuesToItem {

    @Autowired
    AdjustPriceValue adjustPriceValue;

    @Autowired
    SetDefaultValuesToItemVariant setDefaultValuesToItemVariant;

    @Override
    public Item get(@NonNull Item item) {
        if (isNull(item.getPrice()) || item.getPrice().compareTo(BigDecimal.ZERO) == 0) {
            item.setPrice(adjustPriceValue.get(item.getHardPrice()));
        }
        if (isNull(item.getAvailableQuantity())) {
            item.setAvailableQuantity(0L);
        }
        if (isNull(item.getStatus())) {
            item.setStatus(ItemStatus.ACTIVE);
        }
        if (isNull(item.getAttributes())) {
            item.setAttributes(new ArrayList<>());
        }
        if (isNull(item.getAvailableVariants())) {
            item.setAvailableVariants(new ArrayList<>());
        }
        if (isNull(item.getVideos())) {
            item.setVideos(new ArrayList<>());
        }
        if (isNull(item.getTags())) {
            item.setTags(new ArrayList<>());
        }
        item.setVariants(setDefaultValuesToItemVariants(item.getVariants()));
        return item;
    }

    private List<ItemVariant> setDefaultValuesToItemVariants(List<ItemVariant> variants) {
        if (isNull(variants)) {
            return new ArrayList<>();
        }
        return variants.stream()
                .map(itemVariant -> setDefaultValuesToItemVariant.get(itemVariant))
                .collect(Collectors.toList());
    }
}
