package org.GameStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    private int storeId;
    private String storeName;
    private boolean active;

    public Store(){}

    public Store(String storeName, int storeId, boolean active){
        this.storeName = storeName;
        this.storeId = storeId;
        this.active = active;
    }

    public Store(String storeName, int storeId, int active){
        this.storeName = storeName;
        this.storeId = storeId;
        if(active == 1){
            this.active = true;
        } else {
            this.active = false;
        }
    }

    public String getStoreName() {
        return storeName;
    }

    public int getStoreId() {
        return storeId;
    }

    public boolean isActive() {
        return active;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
