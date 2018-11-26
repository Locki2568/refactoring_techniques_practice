package com.tws.refactoring.extract_variable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpstreams(){
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void getPriceWithoutDiscount() {
        double expectedPrice = 1100.0;
        double actualPrice = new PriceCalculator().getPrice(100, 10);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void getPriceWithDiscount() {
        double expectedPrice = 6050.0;
        double actualPrice = new PriceCalculator().getPrice(600, 10);
        assertEquals(expectedPrice, actualPrice);
    }
}