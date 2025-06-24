package com.bcncgroup.pricingservice.domain.enums;

import java.util.List;

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

public enum CurrencyType {
    EURO(1,"EUR", "Euro", "€"),
    DOLLAR(2, "USD", "Dollar", "$"),
    POUND(3, "GBP", "Pound Sterling", "£"),
    YEN(4, "JPY", "Japanese Yen", "¥");

    private final int id;
    private final String code;
    @SuppressWarnings("unused")
    private final String name;
    @SuppressWarnings("unused")
    private final String symbol;

    CurrencyType(int id, String code, String name, String symbol) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Returns the {@link CurrencyType} corresponding to the specified id.
     *
     * @param id the unique identifier of the currency type
     * @return the {@code CurrencyType} with the given id
     * @throws IllegalArgumentException if no currency type with the specified id exists
     */
    public CurrencyType findById(int id) {
        for (CurrencyType currency : CurrencyType.values()) {
            if (currency.id == id) {
                return currency;
            }
        }
        throw new IllegalArgumentException("No currency found with id: " + id);
    }

    /**
     * Finds a CurrencyType by its code.
     *
     * @param code the ISO code of the currency (e.g., "EUR", "USD")
     * @return the CurrencyType corresponding to the given code
     * @throws IllegalArgumentException if no currency with the given code is found
     */
    public CurrencyType findByCode(String code) {
        for (CurrencyType currency : CurrencyType.values()) {
            if (currency.code.equalsIgnoreCase(code)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("No currency found with code: " + code);
    }

    /**
     * Gets a list of all available CurrencyTypes.
     *
     * @return a List containing all CurrencyType values
     */
    public List<CurrencyType> getAll() {
        return List.of(CurrencyType.values());
    }

}
