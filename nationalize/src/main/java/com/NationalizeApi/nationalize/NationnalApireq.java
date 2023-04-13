package com.NationalizeApi.nationalize;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NationnalApireq {
    public static void main(String[] args) throws IOException {

        URL geturl = new URL("https://api.nationalize.io/?name=nathaniel");
        HttpURLConnection connection = (HttpURLConnection) geturl.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponseData = new StringBuilder();
            String readLine;
            while ((readLine = in.readLine()) != null) {
                jsonResponseData.append(readLine);
            }
            in.close();
            JSONObject masterData = new JSONObject(jsonResponseData.toString());
            JSONArray currentCountry = (JSONArray) masterData.get("country");

            JSONObject currentZero = currentCountry.getJSONObject(0);
            System.out.println("Current country_id : " + currentZero.get("country_id"));
            System.out.println("Current probability : " + currentZero.get("probability"));

            JSONObject currentOne = currentCountry.getJSONObject(1);
            System.out.println("Current country_id" + currentOne.get("country_id"));
            System.out.println("current probability" + currentOne.get("probability"));

            JSONObject currentTwo = currentCountry.getJSONObject(2);
            System.out.println("Current country_id" + currentTwo.get("country_id"));
            System.out.println("current probability" + currentTwo.get("probability"));

            JSONObject currentThree = currentCountry.getJSONObject(3);
            System.out.println("Current country_id" + currentThree.get("country_id"));
            System.out.println("current probability" + currentThree.get("probability"));

            System.out.println("Current name " + masterData.get("name"));


        } else {
            System.out.println("This is not valid URL- " + responseCode);
        }
    }
}
