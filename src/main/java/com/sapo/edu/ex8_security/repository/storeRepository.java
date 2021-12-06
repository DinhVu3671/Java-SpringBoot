package com.sapo.edu.ex8_security.repository;

import com.sapo.edu.ex8_security.model.Store;

import java.util.List;

public interface storeRepository {
    List<Store> getAllStore();
    Store getStoreById(String store_Id);
    List<Store> getStoreByName(String name);
    int addStore(Store store);
    int updateStore(Store store);
    int deleteStore(String store_id);
}
