package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(value = Cucumber.class)
//@CucumberOptions(features = "src/test/resources/Features", glue = { "stepDefinitions" },
//monochrome=true,
//		plugin = { "pretty", "json:target/cucumber.json", "junit:target/JunitReports/report.xml",
//				"html: target/cucumber-reports",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@UITest")
//
//public class TestRunner {
//
//}

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty",
                "json:target/cucumber.json",
                "junit:target/JunitReports/report.xml",
                "html: target/cucumber-reports.html",
                "rerun:target/failedrerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@SFTest")

public class TestRunner extends AbstractTestNGCucumberTests {

}