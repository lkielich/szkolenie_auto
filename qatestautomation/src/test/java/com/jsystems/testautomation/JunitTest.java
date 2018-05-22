package com.jsystems.testautomation;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class JunitTest extends ConfigJunit {

    @Before
    public void setUp() {
        System.out.println(">>>>>>>>>>@Before<<<<<<<<");
    }


    @After
    public void tearDown() {
        System.out.println(">>>>>>>>>>@After<<<<<<<<");
    }

    String myString = "First Test";


    @Test
    public void firstTest() {

        assertTrue(true == true);
        assertTrue(myString.equals("First Test"));
        assertFalse("message from assertFalse", 6 == 1 + 3);
        assertThat(myString, is("First Test"));
        assertThat(myString, containsString("Test"));
        assertThat(myString, endsWith("est"));
        assertThat(myString, equalTo("First Test"));
        assertEquals(myString, "First Test");
        assertSame(myString, "First Test");

        //przypisanie wyniku do wartosci 'double'
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal(("0.2"))).doubleValue() == 0.04);

    }

    @Test
    public void arraysTest() {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list1a = Arrays.asList(1,2,3,4,5);
        List<String> list2 = Arrays.asList("Jan","Marta","Tomek");
        List<String> list2a = Arrays.asList("Jan","Marta","Tomek","Kasia");
        List<String> list3 = new ArrayList<>();

        assertArrayEquals(list1.toArray(), list1a.toArray());
        assertThat(list2, hasSize(3));
        assertThat(list1, containsInAnyOrder(1,2,3,4,5));
        assertThat(list2, not(IsEmptyCollection.empty()));
        assertThat(list1.size(), is(5));


    }

    @Test
    public void jCabiTest() {
        assertThat(myString, matchesPattern("^First.*"));
        assertThat("12345", matchesPattern("^[0-5]+"));
    }
}
