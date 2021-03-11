package org.GameStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WatchListGame extends Game{

    private String internalName;
    @Id
    private float normalPrice;
    private int metacriticScore;
    private String steamRatingText;
    private int steamRatingPercent;
    private Date releaseDate;

    public WatchListGame(){

    }

    public WatchListGame(String internalName, String title, int gameId,
                         float normalPrice, int metacriticScore, String steamRatingText, int steamRatingPercent,
                         int steamAppId, Date releaseDate){
        super(title, gameId,steamAppId);
        this.internalName = internalName;
        this.normalPrice = normalPrice;
        this.metacriticScore = metacriticScore;
        this.steamRatingText = steamRatingText;
        this.steamRatingPercent = steamRatingPercent;
        this.releaseDate = releaseDate;
    }

    public WatchListGame(String internalName, String title, int gameId,
                         float normalPrice, int metacriticScore, String steamRatingText, int steamRatingPercent,
                         int steamAppId, long releaseDate){
        super(title, gameId,steamAppId);
        this.internalName = internalName;
        this.normalPrice = normalPrice;
        this.metacriticScore = metacriticScore;
        this.steamRatingText = steamRatingText;
        this.steamRatingPercent = steamRatingPercent;
        this.releaseDate = new Date(releaseDate);
    }

    public String getInternalName() {
        return internalName;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
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

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
