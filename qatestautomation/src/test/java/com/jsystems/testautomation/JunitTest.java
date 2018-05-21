package com.jsystems.testautomation;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class JunitTest {

    @Test
    public void firstTest() {
        String myString = "First Test";

        assertTrue (true==true);
        assertTrue(myString.equals("First Test"));
    }
}
