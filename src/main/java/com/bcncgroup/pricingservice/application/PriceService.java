package com.bcncgroup.pricingservice.application;

import org.springframework.transaction.annotation.Transactional;

import com.bcncgroup.pricingservice.domain.model.Price;
import com.bcncgroup.pricingservice.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class PriceService {

    // PriceRepository is the domain repository that provides access to price data
    private final PriceRepository priceRepository;
    
    /**
    * Domain service injection through constructor
    * This service is responsible for business logic related to prices
    * Is the output of the domain service a Price object
    */
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Finds the applicable price for a given product, brand, and date.
     * <p>
     * This method delegates to the domain repository to perform an optimized query
     * that returns the price with the highest priority for the specified parameters.
     * </p>
     *
     * @param productId the ID of the product for which to find the price
     * @param brandId the ID of the brand for which to find the price
     * @param date the date and time for which the price should be applicable
     * @return an {@link Optional} containing the applicable {@link Price} if found, or empty if no price is applicable
     */
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        // Call the repository method to find the applicable price
        // This method is expected to return the price with the highest priority for the given parameters
        return priceRepository.findApplicablePrice(productId, brandId, date);
    }
}
