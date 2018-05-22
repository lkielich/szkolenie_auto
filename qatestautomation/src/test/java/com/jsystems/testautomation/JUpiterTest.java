package com.jsystems.testautomation;
import com.jsystems.testautomation.ConfigJunit;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.matchers.JUnitMatchers.containsString;


@DisplayName("JUpiter test class")
public class JUpiterTest extends ConfigJUpiter {

    @BeforeEach
    public void setUp() {
        System.out.println(">>>>>>>>>>@BeforeEach<<<<<<<<");
    }


    @AfterEach
    public void tearDown() {
        System.out.println(">>>>>>>>>>@AfterEach<<<<<<<<");
    }

    String myString = "First Test";

    @Nested
    @DisplayName("JUpiter nested class")
    public class JupiterNestedClass {
        @Test
        @DisplayName("Test for checking a string in nested class")
        public void firstTestNested() {

            assertTrue(true == true);
            assertTrue(myString.equals("First Test"));
            assertFalse("message from assertFalse", 6 == 1 + 3);
            assertThat(myString, containsString("Test"));
            assertThat(myString, endsWith("est"));
            assertThat(myString, equalTo("First Test"));
            assertEquals(myString, "First Test");
            assertSame(myString, "First Test");

            //przypisanie wyniku do wartosci 'double'
            assertTrue(new BigDecimal("0.2").multiply(new BigDecimal(("0.2"))).doubleValue() == 0.04);

        }
    }

    @Test
    @DisplayName("Test for checking a string")
    public void firstTest() {

        assertTrue(true == true);
        assertTrue(myString.equals("First Test"));
        assertFalse("message from assertFalse", 6 == 1 + 3);
        assertThat(myString, containsString("Test"));
        assertThat(myString, endsWith("est"));
        assertThat(myString, equalTo("First Test"));
        assertEquals(myString, "First Test");
        assertSame(myString, "First Test");

        //przypisanie wyniku do wartosci 'double'
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal(("0.2"))).doubleValue() == 0.04);

    }
}
