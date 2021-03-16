package org.GameStore.Controller;

import org.GameStore.Model.Game;
import org.GameStore.Model.WatchListGame;
import org.json.JSONObject;

public class WatchListGameController {

    public static boolean addGameToWatchList(int id){
        boolean success = false;
        Game game = GameController.getGameById(id);
        DealController.searchDealsByGame(game);
        return success;
    }

    public static WatchListGame readGameFromDeal(JSONObject jsonDeal){
        return new WatchListGame(jsonDeal.getString("internalName"), jsonDeal.getString("title")
        , jsonDeal.getInt("gameID"), jsonDeal.getFloat("normalPrice")
        , jsonDeal.getInt("metacriticScore"), jsonDeal.getString("steamRatingText")
        , jsonDeal.getInt("steamRatingPercent"), jsonDeal.optInt("steamAppID")
        , jsonDeal.getLong("releaseDate"));
    }
}
