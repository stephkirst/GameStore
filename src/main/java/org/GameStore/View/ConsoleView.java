package org.GameStore.View;

import org.GameStore.Controller.GameController;
import org.GameStore.Controller.StoreController;
import org.GameStore.Controller.WatchListGameController;
import org.GameStore.Model.Game;
import org.GameStore.Model.Store;
import org.GameStore.Service.WebServiceCall;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        String input = null;
        boolean success = StoreController.requestStore();

        System.out.println("Hello friend! " +
                "\n To get Information about a store enter \"store [Name]\" " +
                "\n To get all current deals enter \"game [NameOfGame]\"" +
                "\n To add a game to you watch list enter \" add [GameID\"");

        if(!success){
            System.out.println("Stores could not be loaded. Please run refresh");
        }

        while(input != "Quit"){
            System.out.println("");
            input = scanner.nextLine();

            if(input.contains("store ")){
                List<Store> stores = StoreController.loadStoreByName(input.replace("store ", ""));
                for(Store store : stores){
                    System.out.println("Store name: " + store.getStoreName()
                            + "\n Store ID: " + store.getStoreId()
                            + "\n Is active: " + store.isActive());
                }
            } else if (input.contains("game ")){
                List<Game> games = GameController.getGamesByName(input.replace("game ", ""));
                System.out.println(prettyOutputGames(games));
            } else if (input.contains("add ")){
                String inputValue = input.replace("add ", "");
                int id = Integer.parseInt(inputValue);
                WatchListGameController.addGameToWatchList(id);
            }
        }
    }

    private static String prettyOutputGames(List<Game> games){
        String output = "";
        for(Game game : games){
            output = output + "\n\n" + gameObjString(game);
        }
        return output;
    }

    private static String gameObjString(Game game){
        return "Title: " + game.getTitle()
                + "\n Game ID: " + game.getGameId()
                + "\n Steam App ID: " + game.getSteamAppId();
    }
}
