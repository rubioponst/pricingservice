package com.bcncgroup.pricingservice.adapters.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcncgroup.pricingservice.domain.enums.CurrencyType;

@Entity
@Table(name = "prices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {

    /**
     * Represents a price in the pricing service entity model.
     *
     * This class encapsulates the details of a price, including its ID, product ID,
     * brand ID, start and end dates, price list ID, priority, product price, and currency type.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ID_PRODUCT", nullable = false)
    private Long idProduct;

    @Column(name = "ID_BRAND", nullable = false)
    private Long idBrand;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "ID_PRICE_LIST", nullable = false)
    private Long idPriceList;

    @Column(name = "PRIORITY", nullable = false)
    private int priority;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal productPrice;

    @Column(name = "ID_CURRENCY_TYPE", nullable = false)
    private CurrencyType currency;
    
}