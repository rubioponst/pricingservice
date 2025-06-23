package com.bcncgroup.pricingservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Value;

@Value
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
