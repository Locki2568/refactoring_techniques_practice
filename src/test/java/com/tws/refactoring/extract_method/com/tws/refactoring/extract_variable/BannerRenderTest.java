package com.tws.refactoring.extract_variable;



import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BannerRenderTest {
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
    void renderBanner() {
        String platform = "MAC_something";
        String browser = "IE_something";
        new BannerRender().renderBanner(platform, browser);

        String actualOutput = outContent.toString();
        String expectedOutput = "condition matched";

        assertEquals(expectedOutput, actualOutput);
    }
}