package com.bcncgroup.pricingservice.domain.model;

import java.time.LocalDateTime;

import com.bcncgroup.pricingservice.domain.enums.CurrencyType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Price {
    
    Long productId;
    Long brandId;
    Long priceListId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int priority;
    Float productPrice;
    CurrencyType currency;
    
}
