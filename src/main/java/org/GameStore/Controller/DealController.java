package org.GameStore.Controller;

import org.GameStore.Model.Game;
import org.GameStore.Service.WebServiceCall;
import org.json.JSONArray;

public class DealController {

    public static void readDealsFromJson(String jsonString){
        JSONArray deals = new JSONArray(jsonString);
    }

    public static void searchDealsByGame(Game game){
        String url;
        if(game.getSteamAppId() == 0){
            url = "https://www.cheapshark.com/api/1.0/deals?steamAppID=" + game.getSteamAppId();
        } else {
            url = "https://www.cheapshark.com/api/1.0/deals?title=" + game.getTitle() + "exact=1";
        }
        String response = WebServiceCall.sendRequest(url);

    }

}
