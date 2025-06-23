package com.bcncgroup.pricingservice.domain.enums;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.EnumNaming;

/**
 * Enum representing different currencies with their code, name, and symbol.
 *
 * Each currency has:
 *   A three-letter ISO code (e.g., "JPY")
 *   A display name (e.g., "Japanese Yen")
 *   A symbol (e.g., "¥")
 * 
 *
 * Provides utility methods to retrieve currency information and to find a currency by its code.
 *
 * @author Tomàs Ismael Rubio Pons
 */

public enum Currency {
    EURO("EUR", "Euro", "€"),
    DOLLAR("USD", "Dollar", "$"),
    POUND("GBP", "Pound Sterling", "£"),
    YEN("JPY", "Japanese Yen", "¥");

    private final String code;
    private final String name;
    private final String symbol;

    Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public Currency findByCode(String code) {
        for (Currency currency : Currency.values()) {
            if (currency.code.equalsIgnoreCase(code)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("No currency found with code: " + code);
    }

    public List<Currency> getAll() {
        return List.of(Currency.values());
    }

}
