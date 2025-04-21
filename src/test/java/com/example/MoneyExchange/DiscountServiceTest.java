package com.example.MoneyExchange;

import com.example.MoneyExchange.enums.UserType;
import com.example.MoneyExchange.model.BillRequest;
import com.example.MoneyExchange.model.Item;
import com.example.MoneyExchange.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTest {

    @InjectMocks
    DiscountService applyDiscounts;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEmployeeDiscount() {
        List<Item> items = List.of(
                new Item("TV", 200.0, "non-grocery"),
                new Item("Apple", 100.0, "grocery")
        );

        double result = applyDiscounts.calculateDiscount(new BillRequest(
                items,
                UserType.EMPLOYEE.name(),
                1
        ));

        // 30% on 200 = 140 + 100 = 240, - $10 fixed discount => 230
        assertEquals(225.0, result);
    }
}