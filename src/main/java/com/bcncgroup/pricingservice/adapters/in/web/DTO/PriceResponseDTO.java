package com.bcncgroup.pricingservice.adapters.in.web.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcncgroup.pricingservice.domain.enums.CurrencyType;
import com.bcncgroup.pricingservice.domain.model.Price;


public record PriceResponseDTO(
        Long productId,
        Long brandId,
        Long priceListId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        int priority,
        BigDecimal productPrice,
        CurrencyType currency
) {
    public static PriceResponseDTO fromDomain(Price price) {
        return new PriceResponseDTO(
                price.getIdProduct(),
                price.getIdBrand(),
                price.getIdPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPriority(),
                price.getProductPrice(),
                price.getCurrency()
        );
    }
}