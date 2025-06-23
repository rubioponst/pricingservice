package com.bcncgroup.pricingservice.adapters.out.Repository;

import java.time.LocalDateTime;
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
     * @param productId the ID of the product
     * @param brandId the ID of the brand
     * @param applicationDate the date and time when the price is to be applied
     * @return an Optional containing the applicable Price if found, otherwise empty
     */
    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        return priceJpaRepository
                .findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                        productId, brandId, applicationDate, applicationDate
                )
                .stream()
                .findFirst()
                .map(this::toDomain);
    }

    /**
     * Converts a PriceEntity to a Price domain object.
     *
     * @param entity the PriceEntity to convert
     * @return the converted Price domain object
     */
    private Price toDomain(PriceEntity entity) {
        return Price.builder()
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceListId(entity.getPriceListId())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .productPrice(entity.getProductPrice())
                .currency(entity.getCurrency())
                .build();
    }
}
