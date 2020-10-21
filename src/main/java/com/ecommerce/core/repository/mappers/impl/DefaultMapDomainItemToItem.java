package com.ecommerce.core.repository.mappers.impl;

import com.ecommerce.core.domain.DomainItem;
import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.domain.DomainItemVariant;
import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.repository.mappers.MapDomainItemAttributeToItemAttribute;
import com.ecommerce.core.repository.mappers.MapDomainItemToItem;
import com.ecommerce.core.repository.mappers.MapDomainItemVariantToItemVariant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class DefaultMapDomainItemToItem implements MapDomainItemToItem {

    @Autowired
    MapDomainItemVariantToItemVariant mapDomainItemVariantToItemVariant;

    @Autowired
    MapDomainItemAttributeToItemAttribute mapDomainItemAttributeToItemAttribute;

    @Override
    public Item get(@NonNull DomainItem domainItem) {
        return new Item()
                .setId(domainItem.getId())
                .setTitle(domainItem.getTitle())
                .setSubtitle(domainItem.getSubtitle())
                .setPrice(domainItem.getPrice())
                .setHardPrice(domainItem.getHardPrice())
                .setAvailableQuantity(domainItem.getAvailableQuantity())
                .setStatus(domainItem.getStatus())
                .setSmallPictures(domainItem.getSmallPictures())
                .setPictures(domainItem.getPictures())
                .setVideos(domainItem.getVideos())
                .setTags(domainItem.getTags())
                .setDateCreated(domainItem.getDateCreated())
                .setLastUpdated(domainItem.getLastUpdated())
                .setAvailableVariants(domainItem.getAvailableVariants())
                .setAttributes(mapItemAttributes(domainItem.getAttributes()))
                .setVariants(mapItemVariants(domainItem.getVariants()));
    }

    private List<ItemVariant> mapItemVariants(List<DomainItemVariant> variants) {
        if (isNull(variants)) {
            return new ArrayList<>();
        }
        return variants.stream()
                .map(itemVariant -> mapDomainItemVariantToItemVariant.get(itemVariant))
                .collect(Collectors.toList());
    }

    private List<ItemAttribute> mapItemAttributes(List<DomainItemAttribute> attributes) {
        if (isNull(attributes)) {
            return new ArrayList<>();
        }
        return attributes.stream()
                .map(itemAttribute -> mapDomainItemAttributeToItemAttribute.get(itemAttribute))
                .collect(Collectors.toList());
    }
}