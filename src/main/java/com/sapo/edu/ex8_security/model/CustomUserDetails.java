package com.sapo.edu.ex8_security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
   // Mặc định Spring Security sử dụng một đối tượng UserDetails
   // để chứa toàn bộ thông tin về người dùng.
   // Vì vậy, chúng ta cần tạo ra một class mới
   // giúp chuyển các thông tin của User thành UserDetails

    DAOUser daoUser;

    public CustomUserDetails(DAOUser user) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return daoUser.getPassword();
    }

    @Override
    public String getUsername() {
        return daoUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
