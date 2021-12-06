package com.sapo.edu.ex8_security.repository;

import com.sapo.edu.ex8_security.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}