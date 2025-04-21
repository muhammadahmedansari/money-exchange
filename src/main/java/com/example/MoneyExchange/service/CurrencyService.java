
package com.example.MoneyExchange.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    @Value("${exchange.api-url}")
    private String apiUrl;

    @Value("${exchange.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable("rates")
    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        String url = apiUrl + "/" + apiKey + "/" + baseCurrency;
        Map response = restTemplate.getForObject(url, Map.class);
        if (response != null && response.containsKey("conversion_rates")) {
            Map<String, Double> rates = (Map<String, Double>) response.get("conversion_rates");
            return rates.getOrDefault(targetCurrency, 1.0);
        }
        return 1.0;
    }
}