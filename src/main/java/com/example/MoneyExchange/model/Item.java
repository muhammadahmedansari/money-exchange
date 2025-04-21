
package com.example.MoneyExchange.model;

import lombok.Data;

@Data
public class Item {
    private String name;
    private String category;
    private double price;

    public Item() {
    }

    public Item(String name, double price, String category) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
