package org.example.AcceptanceTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cases",
        plugin = "html:target/cucumber/report.html",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "org.example.AcceptanceTest") // Update the glue attribute with the correct package

public class AcceptanceTest {
}