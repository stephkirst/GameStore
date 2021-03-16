package org.GameStore.Controller;

import org.GameStore.Model.Game;
import org.GameStore.Service.WebServiceCall;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameController {

    private static List<Game> readGamesFromJson(String jsonString){
        List<Game> gameList= new ArrayList<>();
        JSONArray games = new JSONArray(jsonString);

        for(int i = 0; games.length() > i; i++){
            JSONObject jsonGame = games.getJSONObject(i);
            int steamAppId = 0;
            if(!jsonGame.get("steamAppID").equals(null)){
                steamAppId = jsonGame.getInt("steamAppID");
            }
            Game game = new Game(jsonGame.getString("external"),
                    jsonGame.getInt("gameID"),
                    steamAppId);
            gameList.add(game);
        }
        return gameList;
    }

    private static Game readGameFromJson(String jsonString, int id){
        JSONObject jsonGame = new JSONObject(jsonString).getJSONObject("info");
        int steamAppId = 0;
        if(!jsonGame.get("steamAppID").equals(null)){
            steamAppId = jsonGame.getInt("steamAppID");
        }
        return new Game(jsonGame.getString("title"), id, steamAppId);
    }

    public static List<Game> getGamesByName(String title){
        String response = WebServiceCall.sendRequest("https://www.cheapshark.com/api/1.0/games"
                + "?title=" + title);
        if(response != "Error"){
            return readGamesFromJson(response);
        }
        return Collections.emptyList();
    }

    public static Game getGameById(int id){
        String response = WebServiceCall.sendRequest("https://www.cheapshark.com/api/1.0/games"
        + "?id=" + id);

        if(response != "Error"){
            return readGameFromJson(response, id);
        }
        return null;
    }
}
