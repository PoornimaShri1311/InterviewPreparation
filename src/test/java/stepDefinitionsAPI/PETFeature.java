package stepDefinitionsAPI;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.junit.Assert;
import org.testng.Reporter;

import base.BaseAPITest;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.json.simple.parser.ParseException;

import java.util.*;
import java.util.logging.Logger;

public class PETFeature extends BaseAPITest {

    WebDriver driver = null;
    private static Response response;

    @Before
    public void setup() throws IOException {
        try {
            /*
             * System.setProperty("webdriver.chrome.driver",
             * "C:/Users/Poorn/OneDrive/InterviewPreparation/CucumberJava/src/test/resources/drivers/chromedriver.exe"
             * );
             * System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,
             * "true");
             *
             * ChromeOptions ops = new ChromeOptions();
             * ops.addArguments("--diable-notifications");
             * ops.addArguments("--start-maximized"); ops.addArguments("--headless");
             * ops.addArguments("--use-fake-ui-for-media-stream");
             * ops.addArguments("--disable-user-media-security=true");
             *
             * driver = new ChromeDriver(ops);
             */
            Properties props = new Properties();
            FileReader reader = new FileReader(
                    "C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\config.properties");
            props.load(reader);
            RestAssured.baseURI = props.getProperty("BASE_URL_API");
            Reporter.log("Base URL Triggered !!");
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }
    }

//    @When("I add pet to my petStore with {String} and {String}")
//    public void i_add_pet_to_my_pet_store(String arg1, String arg2) {
//        try {
//            RequestSpecification request = RestAssured.given();
//            request.header("Content-Type", "application/json");
//            request.header("Accept", "application/json");
//            response = request.body("{\r\n" + "    \"id\": 12345,\r\n" + "    \"category\": {\r\n"
//                    + "        \"id\": 1,\r\n" + "        \"name\": \"" + arg1 + "\"\r\n" + "    },\r\n"
//                    + "    \"name\": \"" + arg2+"\",\r\n" + "    \"photoUrls\": [\r\n" + "        \"Not Applicable\"\r\n"
//                    + "    ],\r\n" + "    \"tags\": [\r\n" + "        {\r\n" + "            \"id\": 1,\r\n"
//                    + "            \"name\": \"domestic\"\r\n" + "        }\r\n" + "    ],\r\n"
//                    + "    \"status\": \"available\"\r\n" + "}").post("/pet");
//
//            Reporter.log("Pet added request sent!");
//        } catch (Exception e) {
//            // TODO: handle exception
//            Reporter.log(e.toString());
//
//        }
//
//    }

   /* @Then("the pet is available with response code")
    public void the_pet_is_available_with_response_code() {
        try {
            System.out.println("The status code is " + response.getStatusCode() + " as Expected!");
            Reporter.log("The status code is " + response.getStatusCode() + " as Expected!");
            Assert.assertEquals(200, response.getStatusCode());
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }
    }*/

    @And("retrieve the pet name as {string}")
    public void retrieve_the_pet_name_as(String arg1) {
        try {
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.header("Accept", "application/json");
            response = request.body("").get("/pet/12345");

            @SuppressWarnings("rawtypes")
            ResponseBody body = response.getBody();
            Object obj = JSONValue.parse(body.asString());
            JSONObject json = (JSONObject) obj;

            try {
                if (json.containsValue(arg1)) {
                    System.err.println(arg1 + " is available in the response body as Expected!");
                    Reporter.log(arg1 + " is available in the response body as Expected!");
                } else {
                    System.err.println(arg1 + " is not available in the response body!");
                    Reporter.log(arg1 + " is not available in the response body!");
                }
            } catch (Exception e) {

                System.err.println(e);
                Reporter.log(e.toString());

            }
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }

    }

    @When("I update the pet name to {string}")
    public void i_update_the_pet_name_to(String arg1) {
        try {
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.header("Accept", "application/json");
            response = request.body("{\"id\":12345,\"category\":{\"id\":1,\"name\":\"bird\"},\"name\":\"" + arg1
                            + "\",\"photoUrls\":[\"Not Applicable\"],\"tags\":[{\"id\":1,\"name\":\"domestic\"}],\"status\":\"available\"}")
                    .put("/pet");
            Reporter.log("Pet name update request with " + arg1 + " request sent!!");
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }
    }

    /*@When("I delete the pet from PetStore with {String} and {String}")
    public void i_delete_the_pet_from_pet_store(String arg0, String arg1) {
        try {
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.header("Accept", "application/json");
            request.header("api_key", "special-key");
            response = request.body(
                            "{\"id\":12345,\"category\":{\"id\":1,\"name\":\"" + arg0 + "\"},\"name\":\"" + arg1 + "\",\"photoUrls\":[\"Not Applicable\"],\"tags\":[{\"id\":1,\"name\":\"domestic\"}],\"status\":\"available\"}")
                    .delete("/pet/12345");
            Reporter.log("Delete request sent !!");
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }

    }*/

    @Then("the pet is not available with response code")
    public void the_pet_is_not_available_with_response_code() {
        try {
            Assert.assertEquals(200, response.getStatusCode());
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }

    }

    @Then("the pet is not available with response code {int}")
    public void the_pet_is_not_available_with_response_code(Integer arg1) {
        try {
//	Assert.assertSame(response, arg1);
            int argument = arg1;
            int responseValue = response.getStatusCode();
            if (argument == responseValue) {
//		System.out.println("Response code received is same !!");
                Reporter.log("Response code received is same !!");
            } else {
//		System.out.println("Response code received is not same");
                Reporter.log("Response code received is not same");
            }
        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log(e.toString());
        }
    }

    @And("retrieve the pet name as {string} from {string}")
    public void retrieve_the_pet_name_as_from(String arg1, String arg2) throws ParseException {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Accept", "application/json");
        response = request.body("").get("/pet/12345");

        ResponseBody body = response.getBody();
        System.err.println(body.asString());
        String jsonDataString = body.asString();
//		JSONObject jsonObject = new JSONObject(jsonDataString);
//		List<String> list = new ArrayList<String>();
//		JSONArray jsonArray = jsonObject.getJSONArray("category");
//		for (int i = 0; i < jsonArray.length(); i++) {
//			list.add(jsonArray.getJSONObject(i).getString("category"));
//			System.out.println(jsonArray.getJSONObject(i).getString(arg2));
    }

    @When("I add pet to my petStore with {string} and {string}")
    public void iAddPetToMyPetStoreWithAnd(String arg0, String arg1) {
        {
            try {
//                File jsonDataInFile = new File("C:\\Users\\Poorn\\OneDrive\\InterviewPreparation\\CucumberJava\\src\\test\\java\\stepDefinitionsAPI\\addPet.json");
                RequestSpecification request = RestAssured.given();
                request.header("Content-Type", "application/json");
                request.header("Accept", "application/json");
                response = request.body("{\r\n" + "    \"id\": 12345,\r\n" + "    \"category\": {\r\n"
                        + "        \"id\": 1,\r\n" + "        \"name\": \"" + arg0 + "\"\r\n" + "    },\r\n"
                        + "    \"name\": \"" + arg1 + "\",\r\n" + "    \"photoUrls\": [\r\n" + "        \"Not Applicable\"\r\n"
                        + "    ],\r\n" + "    \"tags\": [\r\n" + "        {\r\n" + "            \"id\": 1,\r\n"
                        + "            \"name\": \"domestic\"\r\n" + "        }\r\n" + "    ],\r\n"
                        + "    \"status\": \"available\"\r\n" + "}").post("/pet");
//                response = request.body(jsonDataInFile).post("/pet");
                Reporter.log("Pet added request sent!");
            } catch (Exception e) {
                // TODO: handle exception
                Reporter.log(e.toString());

            }

        }
    }

    @Then("the pet is available with response code {int}")
    public void thePetIsAvailableWithResponseCode(Integer arg0) {
        {
            int argument = arg0;
            int responseValue = response.getStatusCode();
            try {
                System.out.println("The status code is " + response.getStatusCode() + " as Expected!");
                Reporter.log("The status code is " + response.getStatusCode() + " as Expected!");
                Assert.assertEquals(argument, responseValue);
            } catch (Exception e) {
                // TODO: handle exception
                Reporter.log(e.toString());
            }
        }
    }


    @When("I delete the pet from PetStore with {string} and {string}")
    public void iDeleteThePetFromPetStoreWithAnd(String arg0, String arg1) {
        {
            try {
                RequestSpecification request = RestAssured.given();
                request.header("Content-Type", "application/json");
                request.header("Accept", "application/json");
                request.header("api_key", "special-key");
                response = request.body(
                                "{\"id\":12345,\"category\":{\"id\":1,\"name\":\"" + arg0 + "\"},\"name\":\"" + arg1 + "\",\"photoUrls\":[\"Not Applicable\"],\"tags\":[{\"id\":1,\"name\":\"domestic\"}],\"status\":\"available\"}")
                        .delete("/pet/12345");
                Reporter.log("Delete request sent !!");
            } catch (Exception e) {
                // TODO: handle exception
                Reporter.log(e.toString());
            }

        }
    }
}
