package com.sapo.edu.ex8_security.repository.jpa;

import com.sapo.edu.ex8_security.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreJPARepository extends JpaRepository<Store, Long> {

//    Stores findById(int store_id);
}
