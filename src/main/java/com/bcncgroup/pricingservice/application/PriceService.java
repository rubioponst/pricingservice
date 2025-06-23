package com.bcncgroup.pricingservice.application;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class PriceService {

    private final PriceRepository priceRepository;

    // Inyección del repositorio del dominio (puerto de salida)
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * Busca la tarifa de precio aplicable para un producto y cadena en una fecha dada.
     * Aplica la lógica de prioridad para devolver un único precio.
     *
     * @param productId Identificador del producto.
     * @param brandId   Identificador de la cadena (marca).
     * @param date      Fecha de aplicación.
     * @return Optional con la tarifa de precio aplicable si existe.
     */
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        // Delegamos al repositorio del dominio la consulta optimizada que devuelve el precio con mayor prioridad
        return priceRepository.findApplicablePrice(productId, brandId, date);
    }
}
