package org.GameStore.Controller;

import org.GameStore.Model.Deal;
import org.GameStore.Model.Game;
import org.GameStore.Model.Store;
import org.GameStore.Model.WatchListGame;
import org.GameStore.Service.WebServiceCall;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealController {

    private static List<Deal> readDealsFromJson(String jsonString){
        JSONArray jsonDeals = new JSONArray(jsonString);
        List<Deal> deals = new ArrayList<>();

        for(int i = 0; jsonDeals.length() > i; i++){
            JSONObject jsonDeal = jsonDeals.getJSONObject(i);
            WatchListGame game = WatchListGameController.readGameFromDeal(jsonDeal);
            Store store = StoreController.loadStoreById(jsonDeal.getInt("storeID"));
            Deal deal = new Deal(game, store, jsonDeal.getString("dealID")
            , jsonDeal.getFloat("salePrice"), jsonDeal.getFloat("savings")
            , jsonDeal.getFloat("dealRating"), new Date(System.currentTimeMillis()));
            deals.add(deal);
        }
        return deals;
    }

    public static void searchDealsByGame(Game game){
        String url;
        if(game.getSteamAppId() != 0){
            url = "https://www.cheapshark.com/api/1.0/deals?steamAppID=" + game.getSteamAppId();
        } else {
            url = "https://www.cheapshark.com/api/1.0/deals?title=" + game.getTitle() + "exact=1";
        }
        String response = WebServiceCall.sendRequest(url);
        readDealsFromJson(response);

    }

}
