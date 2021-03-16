package org.GameStore.Controller;

import org.GameStore.Model.Game;
import org.GameStore.Service.WebServiceCall;

public class WatchListGameController {

    public boolean addGameToWatchList(int id){
        boolean success = false;
        Game game = GameController.getGameById(id);

        return success;
    }
}
