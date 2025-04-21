
package com.example.MoneyExchange.model;

import lombok.Data;

import java.util.List;

@Data
public class BillRequest {
    private List<Item> items;
    private String userType;
    private int customerTenure;
    private String baseCurrency;
    private String targetCurrency;

    public BillRequest() {
    }

    public BillRequest(List<Item> items, String userType, int customerTenure) {
        this.items = items;
        this.userType = userType;
        this.customerTenure = customerTenure;
    }
}
