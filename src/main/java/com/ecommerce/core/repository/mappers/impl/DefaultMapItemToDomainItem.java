package com.ecommerce.core.repository.mappers.impl;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.domain.DomainItemVariant;
import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.repository.mappers.MapItemAttributeToDomainItemAttribute;
import com.ecommerce.core.repository.mappers.MapItemToDomainItem;
import com.ecommerce.core.repository.mappers.MapItemVariantToDomainItemVariant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class DefaultMapItemToDomainItem implements MapItemToDomainItem {

    @Autowired
    MapItemVariantToDomainItemVariant mapItemVariantToDomainItemVariant;

    @Autowired
    MapItemAttributeToDomainItemAttribute mapItemAttributeToDomainItemAttribute;

    @Override
    public DomainItem get(@NonNull Item item) {
        return new DomainItem()
                .setId(item.getId())
                .setTitle(item.getTitle())
                .setSubtitle(item.getSubtitle())
                .setPrice(item.getPrice())
                .setHardPrice(item.getHardPrice())
                .setAvailableQuantity(item.getAvailableQuantity())
                .setStatus(item.getStatus())
                .setSmallPictures(item.getSmallPictures())
                .setPictures(item.getPictures())
                .setVideos(item.getVideos())
                .setTags(item.getTags())
                .setDateCreated(item.getDateCreated())
                .setLastUpdated(item.getLastUpdated())
                .setAvailableVariants(item.getAvailableVariants())
                .setAttributes(mapItemAttributes(item.getAttributes()))
                .setVariants(mapItemVariants(item.getVariants()));
    }

    private List<DomainItemVariant> mapItemVariants(List<ItemVariant> variants) {
        if (isNull(variants)) {
            return new ArrayList<>();
        }
        return variants.stream()
                .map(itemVariant -> mapItemVariantToDomainItemVariant.get(itemVariant))
                .collect(Collectors.toList());
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