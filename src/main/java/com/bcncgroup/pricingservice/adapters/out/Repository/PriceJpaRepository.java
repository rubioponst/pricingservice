package com.bcncgroup.pricingservice.adapters.out.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcncgroup.pricingservice.adapters.out.entity.PriceEntity;

public interface  PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

        List<PriceEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long productId,
            Long brandId,
            LocalDateTime date1,
            LocalDateTime date2
    );
    
}
