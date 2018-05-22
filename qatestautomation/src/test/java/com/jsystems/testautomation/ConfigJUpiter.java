package com.jsystems.testautomation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigJUpiter {

    public class ConfigJunit {

        @BeforeAll
        public void beforeClass(){
            System.out.println(">>>>>>>>>>@BeforeClass<<<<<<<<");
        }


        @AfterAll
        public void afterClass() {
            System.out.println(">>>>>>>>>>@AfterClass<<<<<<<<");
        }
    }

}
