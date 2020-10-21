package com.ecommerce.core.repository.mappers.impl;

import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.domain.DomainItemVariant;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.repository.mappers.MapItemAttributeToDomainItemAttribute;
import com.ecommerce.core.repository.mappers.MapItemVariantToDomainItemVariant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class DefaultMapItemVariantToDomainItemVariant implements MapItemVariantToDomainItemVariant {

    @Autowired
    MapItemAttributeToDomainItemAttribute mapItemAttributeToDomainItemAttribute;

    @Override
    public DomainItemVariant get(@NonNull ItemVariant itemVariant) {
        return new DomainItemVariant()
                .setId(itemVariant.getId())
                .setPrice(itemVariant.getPrice())
                .setHardPrice(itemVariant.getHardPrice())
                .setAvailableQuantity(itemVariant.getAvailableQuantity())
                .setSmallPictures(itemVariant.getSmallPictures())
                .setPictures(itemVariant.getPictures())
                .setVideos(itemVariant.getVideos())
                .setVariant(mapItemAttributes(itemVariant.getVariant()))
                .setAttributes(mapItemAttributes(itemVariant.getAttributes()));
    }

    private List<DomainItemAttribute> mapItemAttributes(List<ItemAttribute> attributes) {
        if (isNull(attributes)) {
            return new ArrayList<>();
        }
        return attributes.stream()
                .map(itemAttribute -> mapItemAttributeToDomainItemAttribute.get(itemAttribute))
                .collect(Collectors.toList());
    }
}