package com.example.MoneyExchange;

import com.example.MoneyExchange.model.BillRequest;
import com.example.MoneyExchange.model.Item;
import com.example.MoneyExchange.service.CurrencyService;
import com.example.MoneyExchange.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BillingServiceTest {
    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private DiscountService discountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculatePayableAmount() {
        BillRequest request = new BillRequest();
        request.setItems(List.of(
                new Item("TV", 200.0, "non-grocery"),
                new Item("Apple", 100.0, "grocery")
        ));
        request.setUserType("EMPLOYEE");
        request.setCustomerTenure(2);
        request.setBaseCurrency("USD");
        request.setTargetCurrency("EUR");

        when(currencyService.getExchangeRate("USD", "EUR")).thenReturn(1.0);

        Double response = discountService.calculateDiscount(request);
        assertEquals(225.0, response);
    }
}