package com.bcncgroup.pricingservice.adapters.in.web.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcncgroup.pricingservice.adapters.in.web.DTO.PriceResponseDTO;
import com.bcncgroup.pricingservice.application.PriceService;
import com.bcncgroup.pricingservice.domain.model.Price;

@RestController
@RequestMapping("/api/price")
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
     * @param idProduct the ID of the product for which to find the price
     * @param idBrand the ID of the brand for which to find the price
     * @param applicationDate the date and time for which the price should be applicable
     * @return a ResponseEntity containing the applicable PriceResponseDTO or a 404 Not Found response
     */
    @GetMapping("/get-applicable-price")
    public ResponseEntity<PriceResponseDTO> getApplicablePrice(
            @RequestParam Long idProduct,
            @RequestParam Long idBrand,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        Optional<Price> price = priceService.findApplicablePrice(idProduct, idBrand, applicationDate);
        
        /*
         * This method handles the HTTP GET request to retrieve the applicable price.
         * It uses the PriceService to find the price based on the provided parameters.
         * If a price is found, it returns a 200 OK response with the PriceResponseDTO.
         * If no price is found, it returns a 404 Not Found response.  
         */
        return price
                .map(p -> ResponseEntity.ok(PriceResponseDTO.fromDomain(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PriceResponseDTO>> findByIdProduct(@PathVariable Long id) {
        /*
         * This method handles the HTTP GET request to retrieve all prices for a specific product.
         * It uses the PriceService to find all prices associated with the given product ID.
         * If prices are found, it returns a 200 OK response with the PriceResponseDTO.
         * If no prices are found, it returns a 404 Not Found response.
         */
        List<PriceResponseDTO> prices = priceService.findByIdProduct(id)
                .stream()
                .map(PriceResponseDTO::fromDomain)
                .toList();
        if (prices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prices);
    }
    
}
