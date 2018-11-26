package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        int basePrice = quantity * itemPrice;
        double discount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        double shipping_cost = Math.min(quantity * itemPrice * 0.1, 100.0);

        return basePrice - discount + shipping_cost;
//        return quantity * itemPrice -
//                Math.max(0, quantity - 500) * itemPrice * 0.05 +
//                Math.min(quantity * itemPrice * 0.1, 100.0);

    }
}
