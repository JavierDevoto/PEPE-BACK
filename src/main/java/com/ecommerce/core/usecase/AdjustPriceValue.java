package com.ecommerce.core.usecase;

import lombok.NonNull;

import java.math.BigDecimal;

@FunctionalInterface
public interface AdjustPriceValue {
    BigDecimal get(@NonNull BigDecimal hardPrice);
}
