package com.jsystems.testautomation.parametrized;

import com.jsystems.testautomation.ConfigJunit;
import com.jsystems.testautomation.GamePlay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("JUpiter parametrized test with JUnit5")
public class ParametrizedJUpiterTest extends ConfigJunit {

    @ParameterizedTest //sprawdzanie serii parametrow (po dwa - string i int) z warunkami w assertTrue
    @CsvSource({"Hello, 5", "HelloJUnit 5, 20", "'Hello, JUnit 5!', 15"})
    public void parametrizedFirstTest(String param1, int param2){
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5==0);

    }

    //prostsze wersje
    @DisplayName("Check if contains 'Hello' as string param")
    @ParameterizedTest
    @CsvSource({"Hello", "FirstHello", "Hello World"})
    public void parametrizedFirstTestOneParam(String param) {
        assertTrue(param.contains("Hello"));
    }

    @ParameterizedTest
    @CsvSource({"14", "24", "44"})
    public void parametrizedFirstTestOneParam(int param) {
        assertTrue(param % 2==0);
    }

    @DisplayName("Check if file contains params")
    @ParameterizedTest
    @CsvFileSource(resources = "/file.csv")
    public void parametrizedFirstTestCsvFile (String name , int age) {
        assertTrue(age % 5==0);
        assertTrue(name.contains ("Hello"));

    }

    @DisplayName("Check if file contains params")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "Hello Junit5"})
    public void parametrizedFirstTestValueSource (String name) {
        assertTrue(name.contains ("Hello"));
        assertTrue(name instanceof String);

    }

    @DisplayName("Check if file contains params")
    @ParameterizedTest
    @ValueSource(ints = {5,35})
    public void parametrizedFirstTestValueSource (int age) {
        assertTrue(age % 5 == 0);
    }

    GamePlay gamePlay = new GamePlay();

    @Tag("all")
    @Test
    @DisplayName("Test for checking if exception is thrown")
    public void exceptionTest(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    gamePlay.play(0);
                }
        );
    }
}
