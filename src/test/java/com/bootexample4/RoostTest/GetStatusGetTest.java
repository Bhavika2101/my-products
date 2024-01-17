// Test generated by RoostGPT for test java-Qlue-api-spec using AI Type Open AI and AI Model gpt-4-1106-preview


// Test generated for /GetStatus_get for http method type GET in rest-assured framework


// RoostTestHash=637351748e


package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

public class GetStatusGetTest {
  
    @Test  
    public void GetStatus_get_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "bootexample4" + File.separator + "RoostTest" + File.separator + "GetStatusGetTest.csv"))) {  
            String headerLine = reader.readLine();  
            String[] headers = headerLine.split(",");  
  
            String line;  
            while ((line = reader.readLine()) != null) {  
                String[] data = line.split(",");  
  
                // Create a map of header to data  
                Map<String, String> map = new HashMap<>();  
                for (int i = 0; i < headers.length; i++) {  
                    map.put(headers[i], data[i]);  
                }  
                
  
                Response response = given()
				.pathParam("params", map.get("params") != null ? map.get("params") : "")
                .when()
                .get("/GetStatus")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Result OK");
    
              if (response.jsonPath().get("sn") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("sn"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("firmware") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("firmware"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("regStatus") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("regStatus"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("lastOnline") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("lastOnline"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("noCamera") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("noCamera"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("cameras") != null) {    
                for (int i = 0; i < response.jsonPath().getList("cameras").size(); i++) {    
              if (response.jsonPath().get("cameras["+ i +"].no") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cameras["+ i +"].no"), instanceOf(Integer.class));  
          }
    
              if (response.jsonPath().get("cameras["+ i +"].id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cameras["+ i +"].id"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("cameras["+ i +"].status") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cameras["+ i +"].status"), instanceOf(String.class));  
          }
    
              if (response.jsonPath().get("cameras["+ i +"].lastOnline") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("cameras["+ i +"].lastOnline"), instanceOf(String.class));  
          }
    
                  }  
                MatcherAssert.assertThat(response.jsonPath().getList("cameras"), instanceOf(List.class));
  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
				}
if (response.statusCode() == 500) {
					System.out.println("Description: Parameter Error");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
