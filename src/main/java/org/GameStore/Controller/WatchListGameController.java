package org.GameStore.Controller;

import org.GameStore.Model.Deal;
import org.GameStore.Model.Game;
import org.GameStore.Model.Store;
import org.GameStore.Model.WatchListGame;
import org.GameStore.Service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

import java.util.List;

public class WatchListGameController {

    public static boolean addGameToWatchList(int id){
        boolean success = false;
        try {
            Game game = GameController.getGameById(id);
            List<Deal> deals = DealController.searchDealsByGame(game);
            WatchListGame watchListGame = deals.get(1).getWatchListGame();
            saveWatchListGame(watchListGame);
            DealController.saveSavingDeals(deals);
            success = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }

    public static WatchListGame readGameFromDeal(JSONObject jsonDeal){
        return new WatchListGame(jsonDeal.getString("internalName"), jsonDeal.getString("title")
        , jsonDeal.getInt("gameID"), jsonDeal.getFloat("normalPrice")
        , jsonDeal.getInt("metacriticScore"), jsonDeal.getString("steamRatingText")
        , jsonDeal.getInt("steamRatingPercent"), jsonDeal.optInt("steamAppID")
        , jsonDeal.getLong("releaseDate"));
    }

    public static void saveWatchListGame(WatchListGame game){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(game);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static WatchListGame loadGameById(int id){
        Transaction transaction = null;
        WatchListGame watchListGame = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            watchListGame = session.find(WatchListGame.class, id);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return watchListGame;
    }
}
