package com.ecommerce.core.repository.mappers.impl;

import com.ecommerce.core.domain.DomainItemAttribute;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.repository.mappers.MapItemAttributeToDomainItemAttribute;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DefaultMapItemAttributeToDomainItemAttribute implements MapItemAttributeToDomainItemAttribute {

    @Override
    public DomainItemAttribute get(@NonNull ItemAttribute itemAttribute) {
        return new DomainItemAttribute()
                .setType(itemAttribute.getType())
                .setValue(itemAttribute.getValue())
                .setValueCode(itemAttribute.getValueCode());
    }
}
