package org.GameStore.Controller;

import org.GameStore.Model.Store;
import org.GameStore.Service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;


public class StoreController {

    public static void readStoresFromJson(String jsonString){
        JSONArray stores = new JSONArray(jsonString);

        for(int i = 0;  stores.length() > i; i++){
            JSONObject jsonStore = stores.getJSONObject(i);
            Store store = new Store(jsonStore.getString("storeName"),
                    jsonStore.getInt("storeID"),
                    jsonStore.getInt("isActive"));
            saveStore(store);

        }

    }

    public static void saveStore(Store store){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(store);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Store> loadStoreByName(String storeName){
        Transaction transaction = null;
        List<Store> stores = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Store s where s.storeName = :store_name");
            query.setParameter("store_name", storeName);
            stores = query.list();

            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return stores;
    }

}
