package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();

        printBanner();

        double outstanding = calculateOutstanding(elements);

        printDetails(name, outstanding);
    }

    private void printDetails(String name,Double outstanding){
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

    private double calculateOutstanding(Iterator<Order> elements){
        // print owings
        double outstanding = 0.0;
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

//     void printOwing(String name, List<Order> orders) {
//        Iterator<Order> elements = orders.iterator();
//        double outstanding = 0.0;
//
//        // print banner
//        System.out.println("*****************************");
//        System.out.println("****** Customer totals ******");
//        System.out.println("*****************************");
//
//        // print owings
//        while (elements.hasNext()) {
//            Order each = (Order) elements.next();
//            outstanding += each.getAmount();
//        }
//
//        // print details
//        System.out.println("name: " + name);
//        System.out.println("amount: " + outstanding);
//    }
}

