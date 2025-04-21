
package com.example.MoneyExchange.service;

import com.example.MoneyExchange.enums.UserType;
import com.example.MoneyExchange.model.BillRequest;
import com.example.MoneyExchange.model.Item;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double calculateDiscount(BillRequest billRequest) {
        double total = billRequest.getItems().stream().mapToDouble(Item::getPrice).sum();
        double nonGroceryTotal = billRequest.getItems().stream()
                .filter(item -> !item.getCategory().equalsIgnoreCase("grocery"))
                .mapToDouble(Item::getPrice).sum();

        double percentageDiscount = 0.0;
        if (UserType.EMPLOYEE.name().equalsIgnoreCase(billRequest.getUserType())) {
            percentageDiscount = 0.30;
        } else if (UserType.AFFILIATE.name().equalsIgnoreCase(billRequest.getUserType())) {
            percentageDiscount = 0.10;
        } else if (billRequest.getCustomerTenure() >= 2) {
            percentageDiscount = 0.05;
        }

        double discountAmount = nonGroceryTotal * percentageDiscount;
        discountAmount += (int) (total / 100) * 5;

        return total - discountAmount;
    }
}