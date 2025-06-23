package com.bcncgroup.pricingservice.adapters.in.web.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcncgroup.pricingservice.adapters.in.web.DTO.PriceResponseDTO;
import com.bcncgroup.pricingservice.application.PriceService;
import com.bcncgroup.pricingservice.domain.model.Price;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    
    /*
    * PriceController is a REST controller that handles HTTP requests related to prices.
    */

    // PriceService is the application service that contains business logic for prices
    private final PriceService priceService;
    
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Gets the applicable price for a given product, brand, and date.
     *
     * @param applicationDate the date and time for which the price should be applicable
     * @param productId the ID of the product for which to find the price
     * @param brandId the ID of the brand for which to find the price
     * @return a ResponseEntity containing the applicable PriceResponseDTO or a 404 Not Found response
     */
    @GetMapping
    public ResponseEntity<PriceResponseDTO> getApplicablePrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {

        Optional<Price> price = priceService.findApplicablePrice(productId, brandId, applicationDate);

        return price
                .map(p -> ResponseEntity.ok(PriceResponseDTO.fromDomain(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
