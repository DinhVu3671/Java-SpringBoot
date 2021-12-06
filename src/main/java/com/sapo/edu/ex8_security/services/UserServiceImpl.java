package com.sapo.edu.ex8_security.services;


import com.sapo.edu.ex8_security.model.CustomUserDetails;
import com.sapo.edu.ex8_security.model.DAOUser;
import com.sapo.edu.ex8_security.model.UserDTO;
import com.sapo.edu.ex8_security.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;


public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

}
