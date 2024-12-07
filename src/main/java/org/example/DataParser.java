package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class DataParser {

    public static void fetchData(String apiUrl, String dataType) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString();

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(jsonResponse, JsonArray.class);

            System.out.println(dataType + ":");

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                System.out.println(dataType + " " + (i + 1) + ":");
                for (Map.Entry<String, ?> entry : jsonObject.entrySet()) {
                    System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Error fetching " + dataType + ": " + e.getMessage());
        }
    }
}
