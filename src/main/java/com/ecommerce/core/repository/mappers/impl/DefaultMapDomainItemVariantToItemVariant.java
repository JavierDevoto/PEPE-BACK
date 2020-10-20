package com.ecommerce.core.repository.mappers.impl;

import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.domain.DomainItemVariant;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.repository.mappers.MapDomainItemAttributeToItemAttribute;
import com.ecommerce.core.repository.mappers.MapDomainItemVariantToItemVariant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultMapDomainItemVariantToItemVariant implements MapDomainItemVariantToItemVariant {

    @Autowired
    MapDomainItemAttributeToItemAttribute mapDomainItemAttributeToItemAttribute;

    @Override
    public ItemVariant get(@NonNull DomainItemVariant domainItemVariant) {
        return new ItemVariant()
                .setId(domainItemVariant.getId())
                .setPrice(domainItemVariant.getPrice())
                .setHardPrice(domainItemVariant.getHardPrice())
                .setAvailableQuantity(domainItemVariant.getAvailableQuantity())
                .setSmallPictures(domainItemVariant.getSmallPictures())
                .setPictures(domainItemVariant.getPictures())
                .setVideos(domainItemVariant.getVideos())
                .setVariant(mapItemAttributes(domainItemVariant.getVariant()))
                .setAttributes(mapItemAttributes(domainItemVariant.getAttributes()));
    }

    private List<ItemAttribute> mapItemAttributes(List<DomainItemAttribute> attributes) {
        return attributes.stream()
                .map(itemAttribute -> mapDomainItemAttributeToItemAttribute.get(itemAttribute))
                .collect(Collectors.toList());
    }
}