package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.usecase.AdjustPriceValue;
import com.ecommerce.core.usecase.SetDefaultValuesToItemVariant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@Component
public class DefaultSetDefaultValuesToItemVariant implements SetDefaultValuesToItemVariant {

    @Autowired
    AdjustPriceValue adjustPriceValue;

    @Override
    public ItemVariant get(@NonNull ItemVariant itemVariant) {
        if (isNull(itemVariant.getPrice())) {
            itemVariant.setPrice(adjustPriceValue.get(itemVariant.getHardPrice()));
        }
        if (isNull(itemVariant.getAvailableQuantity())) {
            itemVariant.setAvailableQuantity(0L);
        }
        if (isNull(itemVariant.getVideos())) {
            itemVariant.setVideos(new ArrayList<>());
        }
        if (isNull(itemVariant.getAttributes())) {
            itemVariant.setAttributes(new ArrayList<>());
        }
        return itemVariant;
    }
}
