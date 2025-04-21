
package com.example.MoneyExchange.controller;

import com.example.MoneyExchange.model.BillRequest;
import com.example.MoneyExchange.service.CurrencyService;
import com.example.MoneyExchange.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private DiscountService discountService;

    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody BillRequest billRequest) {
        double discountedTotal = discountService.calculateDiscount(billRequest);
        double rate = currencyService.getExchangeRate(billRequest.getBaseCurrency(), billRequest.getTargetCurrency());
        double convertedAmount = discountedTotal * rate;

        Map<String, Object> response = new HashMap<>();
        response.put("payableAmount", convertedAmount);
        response.put("currency", billRequest.getTargetCurrency());
        return response;
    }
}