package com.bcncgroup.pricingservice.adapters.out.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bcncgroup.pricingservice.adapters.out.entity.PriceEntity;
import com.bcncgroup.pricingservice.domain.model.Price;
import com.bcncgroup.pricingservice.domain.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PriceRepositoryAdapter implements PriceRepository{
    private final PriceJpaRepository priceJpaRepository;

    /**
     * Finds the applicable price for a given product and brand at a specific application date.
     *
     * @param idProduct the ID of the product
     * @param brandId the ID of the brand
     * @param applicationDate the date and time when the price is to be applied
     * @return an Optional containing the applicable Price if found, or empty if no applicable price exists
     */
    @Override
    public Optional<Price> findApplicablePrice(Long idProduct, Long idBrand, LocalDateTime applicationDate) {
        
        var priceList = priceJpaRepository.findByIdProductAndIdBrand(idProduct, idBrand);
        
        return priceList
            .stream()
            .filter(price -> price.getStartDate().isBefore(applicationDate) && price.getEndDate().isAfter(applicationDate))
            .max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()))
            .map(this::toDomain);
    }

    /**
     * Retrieves all prices associated with a specific product ID.
     *
     * @param idProduct the ID of the product for which to retrieve prices
     * @return a list of Price objects associated with the specified product ID
     */
    @Override
    public List<Price> findByIdProduct(Long idProduct) {
        return priceJpaRepository
                .findByIdProduct(idProduct)
                .stream()
                .map(this::toDomain)
                .toList();
    }
    

    /**
     * Converts a PriceEntity to a Price domain object.
     *
     * @param entity the PriceEntity to convert
     * @return the converted Price domain object
     */
    private Price toDomain(PriceEntity entity) {
        return Price.builder()
                .idBrand(entity.getIdBrand())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .idPriceList(entity.getIdPriceList())
                .idProduct(entity.getIdProduct())
                .priority(entity.getPriority())
                .productPrice(entity.getProductPrice())
                .currency(entity.getCurrency())
                .build();
    }
}
