package org.GameStore.Service;

import org.GameStore.Controller.GameController;
import org.GameStore.Controller.StoreController;
import org.GameStore.Model.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WebServiceCall {

    public static boolean getStores(String urlString){
        boolean succses = false;
        try {
            HttpURLConnection connection = createConnection(urlString);
            connection.setRequestMethod("GET");
            String response = readResponse(connection);

            StoreController.readStoresFromJson(response);

            succses = true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return succses;

    }

    public static List<Game> getGameByName(String urlString, String gameName){
        List<Game> gameList = null;
        try{
            HttpURLConnection connection = createConnection(urlString + "?title=" + gameName);
            connection.setRequestMethod("GET");
            String response = readResponse(connection);
            gameList = GameController.readGamesFromJson(response);

        } catch(Exception e){
            e.printStackTrace();
        }
        return gameList;
    }

    public static boolean getDeals(String urlString){
        boolean success = false;
        try{
            HttpURLConnection connection = createConnection(urlString);
        }catch(Exception e){
            e.printStackTrace();
        }
        return success;
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
