// ********RoostGPT********
/*
Test generated by RoostGPT for test rest-assured-loader-testing using AI Type Open AI and AI Model gpt-4

Test generated for /employees_post for http method type POST in rest-assured framework

RoostTestHash=b517afeac4


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class employeesPostTest {

    Map<String, String> envs = new HashMap<>();


    @Before
    public void setUp() {
      Dataloader envData = new Dataloader();
      String[] envVariableList = envData.getEnvVariableList("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "employeesPostTest.csv");

      for (String envVar : envVariableList) {
        this.envs.put(envVar, "");
      }
      envData.loadData(envs);
    }


    
    @Test  
    public void employeesPost_Test() {
        Dataloader csvData = new Dataloader();
        List<Map<String, String>> envVarsCSV = csvData.loadFromCSVFile("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "employeesPostTest.csv");
        Map<String, String> map = new HashMap<>();
        for (Map<String, String> row : envVarsCSV) {
          envVars.putAll(envs);
          for (Map.Entry<String, String> entry : row.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!value.equals("")) {
              map.put(key, value);
            }
          }  
          RestAssured.baseURI = map.get("BASE_URL");  
  
                Response response = given()
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"id\": \"" + (map.get("id") != null ? map.get("id") : "") + "\",\n" +
					"  \"jobTitle\": \"" + (map.get("jobTitle") != null ? map.get("jobTitle") : "") + "\",\n" +
					"  \"name\": \"" + (map.get("name") != null ? map.get("name") : "") + "\",\n" +
					"  \"email\": \"" + (map.get("email") != null ? map.get("email") : "") + "\n" +
 				"}")
                .when()
                .post("/employees")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 201) {
					System.out.println("Description: employee created");
				}
if (response.statusCode() == 400) {
					System.out.println("Description: invalid input, object invalid");
				}
if (response.statusCode() == 409) {
					System.out.println("Description: an existing employee already exists");
				}
  
            }  
    }
}
