package com.jsystems.testautomation.frontendBDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //tutaj szuka scenariuszy testowych
        glue = "classpath:com.jsystems.testautomation", //szuka tutaj stepow scenariuszy
        plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"}, //generuje raporty z plugina w target
        tags = {
                "@wordpress"

        }//tagi dla testow, mozna potem wywolywac testy po konkretnych tagach, mozna wywolac tylko z 1 tagiem w cucumberze
        //tylde dajemy przed tagiem, ktorego nie chcemy wywolywac
        //"~@login" //mvn clean install -Dcucumber.option="tags @wordpress"
)
public class RunTest {

}
