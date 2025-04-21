# Currency Discount Application

This Spring Boot application provides an API to calculate the net payable amount on a bill after applying user-specific and item-based discounts. It also supports currency conversion using real-time exchange rates from a third-party API.

---

## 🚀 Features

- ✅ Apply percentage-based discounts:
  - 30% for employees
  - 10% for affiliates
  - 5% for customers with over 2 years tenure
- ✅ $5 discount for every $100 on the bill
- ✅ No percentage discount on groceries
- ✅ Real-time currency exchange rate via Open Exchange Rate API
- ✅ Caching for exchange rates
- ✅ Unit tested and ready for integration with SonarQube

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot 3.2.4
- Spring Web
- Spring Cache
- JUnit 5 + Mockito
- Maven

---

## 📦 API Endpoint

### `POST /api/calculate`

**Request Body:**

```json
{
  "items": [
    { "name": "TV", "category": "non-grocery", "price": 200 },
    { "name": "Apple", "category": "grocery", "price": 100 }
  ],
  "userType": "EMPLOYEE",
  "customerSince": "2020-01-01",
  "originalCurrency": "USD",
  "targetCurrency": "EUR"
}
