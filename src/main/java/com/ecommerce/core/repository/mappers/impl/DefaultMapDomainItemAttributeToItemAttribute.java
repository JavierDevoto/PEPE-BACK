package com.ecommerce.core.repository.mappers.impl;

import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.repository.mappers.MapDomainItemAttributeToItemAttribute;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DefaultMapDomainItemAttributeToItemAttribute implements MapDomainItemAttributeToItemAttribute {

    @Override
    public ItemAttribute get(@NonNull DomainItemAttribute domainItemAttribute) {
        return new ItemAttribute()
                .setType(domainItemAttribute.getType())
                .setValue(domainItemAttribute.getValue())
                .setValueCode(domainItemAttribute.getValueCode());
    }
}
