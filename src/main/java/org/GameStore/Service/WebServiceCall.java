package org.GameStore.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceCall {

    public static String sendRequest(String urlString){
        String response = "Error";
        try{
            HttpURLConnection connection = createConnection(urlString);
            connection.setRequestMethod("GET");
            response = readResponse(connection);
        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private static HttpURLConnection createConnection(String urlString){
        HttpURLConnection connection = null;
        try{
            URL url = new URL(urlString);
             connection = (HttpURLConnection) url.openConnection();

        } catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    private static String readResponse(HttpURLConnection connection) {
        try {
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = responseReader.readLine()) != null) {
                content.append(inputLine);
            }
            responseReader.close();
            return content.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
