package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class BaseAPITest {
	public static Properties prop = new Properties();
	public static FileReader filereader;

	public void setup() throws IOException {
		filereader = new FileReader(
				"C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\config.properties");
		prop.load(filereader);
		RestAssured.baseURI = prop.getProperty("BASE_URL_API");

	}

}
