package base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;
    String fileFolder = "C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\Screenshots\\";
    public Properties props = new Properties();
    public String configFolder = "C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\config.properties";
    Properties dataprops = new Properties();

    @Before
    public void setup() throws IOException {
        FileReader reader = new FileReader(configFolder);
        props.load(reader);
        if (props.getProperty("Browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/Poorn/OneDrive/InterviewPreparation/CucumberJava/src/test/resources/drivers/chromedriver.exe");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            ops.addArguments("--start-maximized");
            ops.addArguments("--use-fake-ui-for-media-stream");
            ops.addArguments("--disable-user-media-security=true");
            driver = new ChromeDriver(ops);
        }
        if (props.get("Browser").equals("edge")) {
            // Set the driver path
            System.setProperty("webdriver.edge.driver", "C:/Users/Poorn/OneDrive/InterviewPreparation/CucumberJava/src/test/resources/drivers/msedgedriver.exe");

            // Start Edge Session
            driver = new EdgeDriver();
        }
        if (props.getProperty("Browser").equals("")) {
            System.setProperty("webdriver.edge.driver", "C:/Users/Poorn/OneDrive/InterviewPreparation/CucumberJava/src/test/resources/drivers/msedgedriver.exe");            // Start Edge Session
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));


    }



    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {
            System.err.println("Taking Screenshot from After Method !");

            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }

    }

    @After(order = 0)
    public void tearDown() throws IOException {
        driver.close();
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        FileReader reader = new FileReader(configFolder);
        props.load(reader);
        if (props.getProperty("ScreenshotOnFailure").equals("No")) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
        if (props.getProperty("ScreenshotOnFailure").equals("Yes")) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "image");
            }
        }
    }
}
