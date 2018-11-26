package com.tws.refactoring.extract_method

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Before
    void setUpstreams(){
        System.setOut(new PrintStream(outContent));
    }
    @After
    void restoreStreams() {
        System.setOut(originalOut);
    }

    //Given some order with value : "1.5, 4.5, 4"
    @Test
    void should_print_outstanding(){
        OwingPrinter owingPrinter = new OwingPrinter();
        Order order1 = new Order(1.5);
        Order order2 = new Order(4.5);
        Order order3 = new Order(4);
        List<Order> orderList = Arrays.asList(order1,order2,order3);
        String outstandingName = "Random Name";
        owingPrinter.printOwing(outstandingName, orderList);

        String expectedOutput = "*****************************\n"+
                "****** Customer totals ******\n"+
                "*****************************\n"+
                "name: Random Name\n"+
                "amount: 10.0";
        String actualOutput = outContent.toString().trim().replace("\r","");

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    void printOwing() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }
}
