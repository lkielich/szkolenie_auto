package com.jsystems.testautomation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class ConfigJUpiter {

        @BeforeAll
        public void beforeClass(){
            System.out.println(">>>>>>>>>>@BeforeAll<<<<<<<<");
        }


        @AfterAll
        public void afterClass() {
            System.out.println(">>>>>>>>>>@AfterAll<<<<<<<<");
        }

}

