package org.GameStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Deal {

    @ManyToOne
    private Game game;

    @ManyToOne
    private Store store;

    @Id
    private String dealId;

    private float salePrice;
    private float savings;
    private float dealRating;

    public Deal(){

    }

    public Deal(Game game, Store store, String dealId, float salePrice, float savings, float dealRating){
        this.game = game;
        this.store = store;
        this.dealId = dealId;
        this.salePrice = salePrice;
        this.savings = savings;
        this.dealRating = dealRating;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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
}
