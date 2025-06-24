package com.bcncgroup.pricingservice.application;

import org.springframework.transaction.annotation.Transactional;

import com.bcncgroup.pricingservice.domain.model.Price;
import com.bcncgroup.pricingservice.domain.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.List;
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
     * @param idProduct the ID of the product for which to find the price
     * @param idBrand the ID of the brand for which to find the price
     * @param applicationDate the date and time for which the price should be applicable
     * @return an {@link Optional} containing the applicable {@link Price} if found, or empty if no price is applicable
     */
    public Optional<Price> findApplicablePrice(Long idProduct, Long idBrand, LocalDateTime applicationDate) {
        // Call the repository method to find the applicable price
        // This method is expected to return the price with the highest priority for the given parameters
        return priceRepository.findApplicablePrice(idProduct, idBrand, applicationDate);
    }

    /**
     * Retrieves all prices for a specific product.
     *
     * @param idProduct the ID of the product for which to retrieve prices
     * @return a list of {@link Price} objects associated with the specified product ID
     */
    public List<Price> findByIdProduct(Long idProduct) {
        // Retrieves all prices from the repository
        return priceRepository.findByIdProduct(idProduct);
    }
}
