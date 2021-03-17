package org.GameStore.Controller;

import org.GameStore.Model.Deal;
import org.GameStore.Model.Game;
import org.GameStore.Model.Store;
import org.GameStore.Model.WatchListGame;
import org.GameStore.Service.HibernateUtil;
import org.GameStore.Service.WebServiceCall;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public static List<Deal> searchDealsByGame(Game game){
        String url;
        if(game.getSteamAppId() != 0){
            url = "https://www.cheapshark.com/api/1.0/deals?steamAppID=" + game.getSteamAppId();
        } else {
            url = "https://www.cheapshark.com/api/1.0/deals?title=" + game.getTitle() + "exact=1";
        }
        String response = WebServiceCall.sendRequest(url);
        List<Deal> deals = readDealsFromJson(response);

        for(Deal deal : deals){
            if(deal.getWatchListGame().getGameId() != game.getGameId()){
                deals.remove(deal);
            }
        }
        return deals;
    }

    public static void saveSavingDeals(List<Deal> deals){
        for(Deal deal : deals){
            if(deal.getSavings() > 0){
                saveDeal(deal);
            }
        }
    }

    public static void saveDeal(Deal deal){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(deal);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
