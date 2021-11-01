package org.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/org/example/feature"},
        tags = {"@createNew"},
        glue = {"org.example.Steps"}

)
public class TestRunner {

}
