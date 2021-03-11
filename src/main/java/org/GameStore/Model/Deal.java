package org.GameStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Deal {

    @ManyToOne
    private WatchListGame watchListGame;

    @ManyToOne
    private Store store;

    @Id
    private String dealId;

    private float salePrice;
    private float savings;
    private float dealRating;
    private Date dealDateFrom;
    private Date dealDateTo;

    public Deal(){

    }

    public Deal(WatchListGame watchListGame, Store store, String dealId, float salePrice, float savings, float dealRating, Date dealDateFrom){
        this.watchListGame = watchListGame;
        this.store = store;
        this.dealId = dealId;
        this.salePrice = salePrice;
        this.savings = savings;
        this.dealRating = dealRating;
        this.dealDateFrom = dealDateFrom;
    }

    public Deal(WatchListGame watchListGame, Store store, String dealId, float salePrice, float savings, float dealRating, Date dealDateFrom, Date dealDateTo){
        this.watchListGame = watchListGame;
        this.store = store;
        this.dealId = dealId;
        this.salePrice = salePrice;
        this.savings = savings;
        this.dealRating = dealRating;
        this.dealDateFrom = dealDateFrom;
        this.dealDateTo = dealDateTo;
    }

    public WatchListGame getGame() {
        return watchListGame;
    }

    public void setGame(WatchListGame watchListGame) {
        this.watchListGame = watchListGame;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getSavings() {
        return savings;
    }

    public void setSavings(float savings) {
        this.savings = savings;
    }

    public float getDealRating() {
        return dealRating;
    }

    public void setDealRating(float dealRating) {
        this.dealRating = dealRating;
    }

    public Date getDealDateFrom() {
        return dealDateFrom;
    }

    public void setDealDateFrom(Date dealDateFrom) {
        this.dealDateFrom = dealDateFrom;
    }

    public Date getDealDateTo() {
        return dealDateTo;
    }

    public void setDealDateTo(Date dealDateTo) {
        this.dealDateTo = dealDateTo;
    }
}
