package org.GameStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Game {

    private String internalName;
    private String title;
    @Id
    private int gameId;
    private float normalPrice;
    private int metacriticScore;
    private String steamRatingText;
    private int steamRatingPercent;
    private int steamAppId;
    private Date releaseDate;

    public Game(){

    }

    public Game(String internalName, String title, int gameId,
                float normalPrice, int metacriticScore, String steamRatingText, int steamRatingPercent,
                int steamAppId, Date releaseDate){
        this.internalName = internalName;
        this.title = title;
        this.gameId = gameId;
        this.normalPrice = normalPrice;
        this.metacriticScore = metacriticScore;
        this.steamRatingText = steamRatingText;
        this.steamRatingPercent = steamRatingPercent;
        this.steamAppId = steamAppId;
        this.releaseDate = releaseDate;
    }

    public Game(String internalName, String title, int gameId,
                float normalPrice, int metacriticScore, String steamRatingText, int steamRatingPercent,
                int steamAppId, long releaseDate){
        this.internalName = internalName;
        this.title = title;
        this.gameId = gameId;
        this.normalPrice = normalPrice;
        this.metacriticScore = metacriticScore;
        this.steamRatingText = steamRatingText;
        this.steamRatingPercent = steamRatingPercent;
        this.steamAppId = steamAppId;
        this.releaseDate = new Date(releaseDate);
    }

    public String getInternalName() {
        return internalName;
    }

    public String getTitle() {
        return title;
    }

    public int getGameId() {
        return gameId;
    }

    public float getNormalPrice() {
        return normalPrice;
    }

    public int getMetacriticScore() {
        return metacriticScore;
    }

    public String getSteamRatingText() {
        return steamRatingText;
    }

    public int getSteamRatingPercent() {
        return steamRatingPercent;
    }

    public int getSteamAppId() {
        return steamAppId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setNormalPrice(float normalPrice) {
        this.normalPrice = normalPrice;
    }

    public void setMetacriticScore(int metacriticScore) {
        this.metacriticScore = metacriticScore;
    }

    public void setSteamRatingText(String steamRatingText) {
        this.steamRatingText = steamRatingText;
    }

    public void setSteamRatingPercent(int steamRatingPercent) {
        this.steamRatingPercent = steamRatingPercent;
    }

    public void setSteamAppId(int steamAppId) {
        this.steamAppId = steamAppId;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
