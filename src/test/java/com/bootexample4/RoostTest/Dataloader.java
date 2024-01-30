package com.bootexample4.RoostTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Arrays;

public class Dataloader {

  public Map<String, String> myHashMap = new HashMap<>();

  public String loadFromEnvVariables(String name) {
    return System.getenv(name);
  }

  public String loadFromPropertiesFile(String name) {
    Properties properties = new Properties();

    try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
      if (input == null) {
        System.out.println("Sorry, unable to find application.properties");
        return null;
      }
      properties.load(input);
      return properties.getProperty(name);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Map<String, String>> loadFromCSVFile(String filePath) {
    List<Map<String, String>> data = loadCSV(filePath);
    return data;
  }

  public static List<Map<String, String>> loadCSV(String filePath) {
    List<Map<String, String>> data = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean headerSkipped = false;
      List<String> headers = new ArrayList<>();

      while ((line = br.readLine()) != null) {
        if (!headerSkipped) {
          headers.addAll(List.of(line.split(",")));
          headerSkipped = true;
          continue;
        }

        String[] values = line.split(",");
        if (values.length > 0) {
          Map<String, String> row = new HashMap<>();
          for (int i = 0; i < Math.min(headers.size(), values.length); i++) {
            row.put(headers.get(i), values[i].trim());
          }
          data.add(row);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return data;
  }

  public void loadData(Map<String, String> output) {
    for (String key : output.keySet()) {
      String value = this.loadFromEnvVariables(key);
      if (value != null) {
        output.put(key, value);
      }
      value = this.loadFromPropertiesFile(key);
      if (value != null) {
        output.put(key, value);
      }
    }
  }

  public String[] getEnvVariableList(String csvFileName) {
    String[] envVars = { "BASE_URL", "API_KEY" };
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
      String headerLine = reader.readLine();
      String[] csvHeaders = headerLine.split(",");

      String[] finalEnvArray = new String[csvHeaders.length + envVars.length];
      for (int i = 0; i < envVars.length; i++) {
        finalEnvArray[i] = envVars[i];
      }

      for (int i = 0; i < csvHeaders.length; i++) {
        finalEnvArray[envVars.length + i] = csvHeaders[i];
      }
      System.out.println(finalEnvArray);
      return finalEnvArray;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return envVars;
  }
}
