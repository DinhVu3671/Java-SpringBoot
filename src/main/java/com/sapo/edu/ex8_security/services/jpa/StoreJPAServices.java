package com.sapo.edu.ex8_security.services.jpa;

import com.sapo.edu.ex8_security.model.Store;
import com.sapo.edu.ex8_security.repository.jpa.StoreJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static java.time.LocalDate.now;


@Service
public class StoreJPAServices {

    private final StoreJPARepository storeJPARepository;
    @Autowired
    public StoreJPAServices(com.sapo.edu.ex8_security.repository.jpa.StoreJPARepository storeJPARepository) {
        this.storeJPARepository = storeJPARepository;
    }

    // Lấy danh sách tất cả Store
    @Transactional
    public List<Store> getAllStore(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return storeJPARepository.findAll(pageable).toList();
    }

    // Lấy danh sách Store theo Id
    @Transactional
    public Store getStoreById(long store_id) {
        if (store_id < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "store_id invalid");
        Store store = storeJPARepository.findById(store_id).get();
        return store;
    }

    // Tao moi 1 store
    @Transactional
    public Store createNewStore(Store store) {
        store.setCreateTime(Timestamp.from(Instant.now()));
        store.setUpdateTime(Timestamp.from(Instant.now()));
        storeJPARepository.save(store);
        return store;
    }

    // Cap nhat mot store
    @Transactional
    public Store updateStore(int store_id, Store newStore){
        Store storeUpdate = storeJPARepository.findById((long) store_id).get();

        storeUpdate.setCode(newStore.getCode());
        storeUpdate.setName(newStore.getName());
        storeUpdate.setAddress(newStore.getAddress());
        storeUpdate.setUpdateTime(Timestamp.from(Instant.now()));

        storeJPARepository.save(storeUpdate);
        return storeUpdate;
    }

    // Xoa mot store
    @Transactional
    public void deleteStore(int store_id){
        if (store_id < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "store_id invalid");
        storeJPARepository.deleteById((long) store_id);
    }
}
