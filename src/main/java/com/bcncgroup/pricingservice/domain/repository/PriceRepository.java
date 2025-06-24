package com.bcncgroup.pricingservice.domain.repository;

import com.bcncgroup.pricingservice.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository {
    /**
     * Finds the applicable price for a given product and brand at a specific application date.
     *
     * @param productId the ID of the product
     * @param brandId the ID of the brand
     * @param applicationDate the date and time when the price is to be applied
     * @return an Optional containing the applicable Price if found, or empty if no applicable price exists
     */
    Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate);

    /**
     * Retrieves all prices associated with a specific product ID.
     *
     * @param idProduct the ID of the product for which to retrieve prices
     * @return a list of Price objects associated with the specified product ID
     */
    List<Price> findByIdProduct(Long idProduct);
    
}
