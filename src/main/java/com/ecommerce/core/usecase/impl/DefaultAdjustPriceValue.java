package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.usecase.AdjustPriceValue;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DefaultAdjustPriceValue implements AdjustPriceValue {

    private static final BigDecimal badgeValue = new BigDecimal(160);

    @Override
    public BigDecimal get(@NonNull BigDecimal hardPrice) {
        return hardPrice.multiply(badgeValue);
    }
}
