package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(value = Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"},
//monochrome=true,
plugin=
{
//	"pretty",
	"json:target/cucumber.json",
//	"junit:target/JunitReports/report.xml",
//	"html:target/HtmlReports/"
},
tags="@SmokeTest")


public class TestRunner {

}
