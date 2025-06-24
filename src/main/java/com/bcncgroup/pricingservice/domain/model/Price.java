package com.bcncgroup.pricingservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcncgroup.pricingservice.domain.enums.CurrencyType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Price {

    /**
     * Represents a price in the pricing service domain model.
     *
     * This class encapsulates the details of a price, including its ID, product ID,
     * brand ID, start and end dates, price list ID, priority, product price, and currency type.
     */

    Long id;
    Long idProduct;
    Long idBrand;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Long idPriceList;
    int priority;
    BigDecimal productPrice;
    CurrencyType currency;

}