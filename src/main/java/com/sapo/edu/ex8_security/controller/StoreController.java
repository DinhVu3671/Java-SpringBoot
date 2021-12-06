package com.sapo.edu.ex8_security.controller;

import javax.validation.Valid;
import com.sapo.edu.ex8_security.model.Store;
import com.sapo.edu.ex8_security.services.jpa.StoreJPAServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/store")
public class StoreController {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Autowired
    private StoreJPAServices storeJPAServices;

    // lấy ra tất cả danh sách store
    @GetMapping
    public ResponseEntity<List<Store>> listStore(@RequestParam("page") int page, @RequestParam("size") int size){
        List<Store> listAllStore= storeJPAServices.getAllStore(page, size);
        if(listAllStore.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Store>>(listAllStore, HttpStatus.OK);
    }

    // lấy store theo store_id
    @GetMapping("/{store_id}")
    public ResponseEntity<Store> getStoreById(@PathVariable int store_id) {
        Store store = storeJPAServices.getStoreById(store_id);
//        if(stores != null){
            return new ResponseEntity<Store>(store, HttpStatus.OK);
//        }
//        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Cập nhật thông tin một store
    @PutMapping("/{store_id}")
    public ResponseEntity<Store> updateStoreById(@PathVariable(value = "store_id") int store_id,
                                                 @Valid @RequestBody Store storeNew) {
        Store storeUpdate = storeJPAServices.updateStore(store_id, storeNew);

//        storeUpdate.setCode(storeNew.getCode());
//        storeUpdate.setName(storeNew.getName());
//        storeUpdate.setAddress(storeNew.getAddress());
//        storeUpdate.setUpdateTime(storeNew.getUpdateTime());

        return new ResponseEntity<Store>(storeUpdate, HttpStatus.OK);

    }

    // Thêm 1 store mới
    @PostMapping
    public ResponseEntity<Store> createNewStore(@Valid @RequestBody Store store) {
        return new ResponseEntity<>(storeJPAServices.createNewStore(store), HttpStatus.OK);
//        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    // Xoá 1 store
    @DeleteMapping("/{store_id}")
    public ResponseEntity deleteStore(@PathVariable(value = "store_id") int store_id) {
        Store store = storeJPAServices.getStoreById(store_id);
        if(store != null) {
            storeJPAServices.deleteStore(store_id);
            return new ResponseEntity<>(store, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}






