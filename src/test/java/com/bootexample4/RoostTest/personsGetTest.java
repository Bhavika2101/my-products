// ********RoostGPT********
/*
Test generated by RoostGPT for test rest-assured-loader-testing using AI Type Open AI and AI Model gpt-4

Test generated for /recipients/persons_get for http method type GET in rest-assured framework

RoostTestHash=aa0a5d4980


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

public class personsGetTest {

    Map<String, String> envs = new HashMap<>();


    @Before
    public void setUp() {
      Dataloader envData = new Dataloader();
      String[] envVariableList = envData.getEnvVariableList("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "personsGetTest.csv");

      for (String envVar : envVariableList) {
        this.envs.put(envVar, "");
      }
      envData.loadData(envs);
    }


    
    @Test  
    public void personsGet_Test() {
        Dataloader csvData = new Dataloader();
        List<Map<String, String>> envVarsCSV = csvData.loadFromCSVFile("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "personsGetTest.csv");
        Map<String, String> envVars = new HashMap<>();
        for (Map<String, String> row : envVarsCSV) {
          envVars.putAll(envs);
          for (Map.Entry<String, String> entry : row.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!value.equals("")) {
              envVars.put(key, value);
            }
          }  
          RestAssured.baseURI = System.getenv("BASE_URL");  
  
                Response response = given()
				.pathParam("size", map.get("size") != null ? map.get("size") : "")
				.pathParam("offset", map.get("offset") != null ? map.get("offset") : "")
				.pathParam("name", map.get("name") != null ? map.get("name") : "")
				.pathParam("birth-date", map.get("birth-date") != null ? map.get("birth-date") : "")
				.header("Token", System.getenv("API_KEY"))
                .when()
                .get("/recipients/persons")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: successful operation");
    
              if (response.jsonPath().get("total") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("total"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("persons") != null) {    
                for (int i = 0; i < response.jsonPath().getList("persons").size(); i++) {    
              if (response.jsonPath().get("persons["+ i +"].id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].id"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].initials") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].initials"), matchesPattern("^[A-Z]{1,6}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].initials"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].firstName") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].firstName"), matchesPattern("^[\p{L} .'-]{1,50}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].firstName"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].middleName") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].middleName"), matchesPattern("^[\p{L} .'-]{1,20}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].middleName"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].lastName") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].lastName"), matchesPattern("^[\p{L} .'-]{2,50}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].lastName"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].birthDate") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].birthDate"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].birthPlace") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].birthPlace"), matchesPattern("^[\p{L} .,'-]{2,100}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].birthPlace"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].phone") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].phone"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].email") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].email"), matchesPattern("^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].email"), instanceOf(String.class));MatcherAssert.assertThat(
                  response.jsonPath().getString("persons["+ i +"].email"),
                  Matchers.matchesPattern("^[^\s@]+@[^\s@]+\.[^\s@]+$")
                ); 
  
          }
    
              if (response.jsonPath().get("persons["+ i +"].postalCode") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].postalCode"), matchesPattern("^[0-9]{4}[A-Z]{2}$|^[0-9]{4,5}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].postalCode"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].houseNumber") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].houseNumber"), matchesPattern("^\d{1,6}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].houseNumber"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].houseNumberPostfix") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].houseNumberPostfix"), matchesPattern("^[a-zA-Z .,_'-]{0,20}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].houseNumberPostfix"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].countryCode") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].countryCode"), matchesPattern("^[A-Z]{2}$")); 

                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].countryCode"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].reference") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].reference"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.jsonPath().getString("persons["+ i +"].reference").length(), lessThanOrEqualTo(100));
  
          }
    
              if (response.jsonPath().get("persons["+ i +"].createdAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].createdAt"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("persons["+ i +"].updatedAt") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("persons["+ i +"].updatedAt"), instanceOf(String.class));  
          }
    
                  }  
                MatcherAssert.assertThat(response.jsonPath().getList("persons"), instanceOf(List.class));
  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
    
              if (response.jsonPath().get("error") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 

                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("value") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
    
              if (response.jsonPath().get("field") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("schema_field") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Authentication Required");
    
              if (response.jsonPath().get("error") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 

                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("value") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
    
              if (response.jsonPath().get("field") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("schema_field") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
