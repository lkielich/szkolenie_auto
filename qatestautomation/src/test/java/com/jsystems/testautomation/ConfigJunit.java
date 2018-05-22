package com.jsystems.testautomation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;

public class ConfigJunit {

    @BeforeAll
    public static void beforeClass(){
        System.out.println(">>>>>>>>>>@BeforeClass<<<<<<<<");
    }


    @AfterClass
    public static void afterClass() {
        System.out.println(">>>>>>>>>>@AfterClass<<<<<<<<");
    }
}
