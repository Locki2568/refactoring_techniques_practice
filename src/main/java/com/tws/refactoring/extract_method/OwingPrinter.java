package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();
        double outstanding = 0.0;

        printBanner();

        // print details
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }

    private void printBanner(){
        // print banner
        final String banner = "*****************************\n"+
                                "****** Customer totals ******\n"+
                                "*****************************";
        System.out.println (banner);
    }

    private double claculateOutstanding(Iterator<Order> elements){
        // print owings
        double outstanding = 0.0;
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    private class Order {
        private final double amount;

        public Order(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }
}
