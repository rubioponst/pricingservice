package com.bcncgroup.pricingservice.adapters.out.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcncgroup.pricingservice.adapters.out.entity.PriceEntity;

public interface  PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    /**
     * Finds the applicable prices for a given product and brand within a specific date range.
     *
     * @param idProduct the ID of the product
     * @param idBrand the ID of the brand
     * @param applicationDate the date and time when the price is to be applied
     * @return a list of PriceEntity objects that match the criteria
     */
    Optional<PriceEntity> findByIdProductAndIdBrand(
        Long idProduct,
        Long idBrand
    );

    /**
     * Retrieves all prices associated with a specific product ID.
     *
     * @param productId the ID of the product for which to retrieve prices
     * @return a list of PriceEntity objects associated with the specified product ID
     */
    List<PriceEntity> findByIdProduct(Long productId);
    
}
