package com.ecommerce.core.usecase.impl;

import com.ecommerce.core.dto.AttributeType;
import com.ecommerce.core.dto.Item;
import com.ecommerce.core.dto.ItemAttribute;
import com.ecommerce.core.dto.ItemVariant;
import com.ecommerce.core.exceptions.InvalidParametersException;
import com.ecommerce.core.usecase.ValidateItemCreation;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class DefaultValidateItemCreation implements ValidateItemCreation {

    @Override
    public void execute(@NonNull Item item) {
        List<String> errors = new ArrayList<>();
        if (isNullOrEmpty(item.getTitle())) {
            errors.add("item.title is required");
        }
        if (isNullOrEmpty(item.getSubtitle())) {
            errors.add("item.subtitle is required");
        }
        if (isItemWithVariants(item)) {
            validateItemWithVariants(item, errors);
        } else {
            validateItemWithoutVariants(item, errors);
        }

        if (!errors.isEmpty()) {
            throw new InvalidParametersException("There was an error trying to create Item", errors);
        }
    }

    private void validateItemWithoutVariants(Item item, List<String> errors) {
        if (isNull(item.getHardPrice()) || item.getHardPrice().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("item.hard_price is required and has to be > 0");
        }
        if (isNull(item.getPictures()) || item.getPictures().isEmpty()) {
            errors.add("item.pictures must have at least one value");
        }
        if (isNull(item.getSmallPictures()) || item.getSmallPictures().isEmpty()) {
            errors.add("item..small_pictures must have at least one value");
        }
    }

    private void validateItemWithVariants(Item item, List<String> errors) {
        if (isNull(item.getAvailableVariants()) || item.getAvailableVariants().isEmpty()) {
            errors.add("item.available_variants is required when creating a variant item");
        }
        for (int i = 0; i < item.getVariants().size(); i++) {
            validateItemVariant(item.getAvailableVariants(), item.getVariants().get(i), i, errors);
        }
    }

    private void validateItemVariant(List<AttributeType> availableVariants, ItemVariant itemVariant, int index, List<String> errors) {
        if (isNull(itemVariant.getHardPrice()) || itemVariant.getHardPrice().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("item.variants[" + index + "].hard_price is required and has to be > 0");
        }
        if (isNull(itemVariant.getPictures()) || itemVariant.getPictures().isEmpty()) {
            errors.add("item.variants[" + index + "].pictures must have at least one value");
        }
        if (isNull(itemVariant.getSmallPictures()) || itemVariant.getSmallPictures().isEmpty()) {
            errors.add("item.variants[" + index + "].small_pictures must have at least one value");
        }
        if (isNull(itemVariant.getVariant()) || itemVariant.getVariant().isEmpty() || !itemVariantHasAllAvailableVariants(availableVariants, itemVariant)) {
            errors.add("item.variants[" + index + "].variant must have defined all item.available_variants");
        }
        if (itemVariantHasMoreVariantsDefined(availableVariants, itemVariant)) {
            errors.add("item.variants[" + index + "].variant can't define variants that are not listed in item.available_variants");
        }
    }

    private boolean itemVariantHasMoreVariantsDefined(List<AttributeType> availableVariants, ItemVariant itemVariant) {
        if (isNull(availableVariants)) {
            return false;
        }
        return !availableVariants.containsAll(itemVariant.getVariant().stream().map(ItemAttribute::getType).collect(Collectors.toList()));
    }

    private boolean itemVariantHasAllAvailableVariants(List<AttributeType> availableVariants, ItemVariant variant) {
        if (isNull(availableVariants)) {
            return true;
        }
        for (AttributeType availableVariant : availableVariants) {
            if (variant.findVariant(availableVariant).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean isItemWithVariants(Item item) {
        return nonNull(item.getVariants()) && !item.getVariants().isEmpty();
    }
}
