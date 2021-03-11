package org.GameStore.Model;

public class Game {
    private String title;
    private int gameId;
    private int steamAppId;

    public Game(){

    }

    public Game(String title, int gameId, int steamAppId){
        this.title = title;
        this.gameId = gameId;
        this.steamAppId = steamAppId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getSteamAppId() {
        return steamAppId;
    }

    public void setSteamAppId(int steamAppId) {
        this.steamAppId = steamAppId;
    }
}
