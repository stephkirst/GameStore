package org.GameStore.Controller;

import org.GameStore.Model.Game;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public static List<Game> readGamesFromJson(String jsonString){
        List<Game> gameList= new ArrayList<>();
        JSONArray games = new JSONArray(jsonString);

        for(int i = 0; games.length() > i; i++){
            JSONObject jsonGame = games.getJSONObject(i);
            Game game = new Game(jsonGame.getString("external"),
                    jsonGame.getInt("gameID"),
                    jsonGame.getInt("steamAppID"));
            gameList.add(game);
        }
        return gameList;
    }

    public static String prettyOutputGames(List<Game> games){
        String output = "";
        for(Game game : games){
            output = "\n" + gameObjString(game);
        }
        return output;
    }

    public static String gameObjString(Game game){
        return "Title: " + game.getTitle()
                + "\n Game ID: " + game.getGameId()
                + "\n Steam App ID: " + game.getSteamAppId();
    }
}