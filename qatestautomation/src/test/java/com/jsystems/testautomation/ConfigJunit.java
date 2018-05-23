package com.jsystems.testautomation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class ConfigJunit {

    @BeforeAll
    public static void beforeAll(){
        System.out.println(">>>>>>>>>>@BeforeClass<<<<<<<<");
    }


    @AfterAll
    public static void afterAll() {
        System.out.println(">>>>>>>>>>@AfterClass<<<<<<<<");
    }
}
