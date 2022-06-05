package com.dlc.server.service;

//import com.dlc.server.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

//public class UserDetailsImpl implements UserDetails {
//
//    private final User user;
//
//    public UserDetailsImpl(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getAuthorities()
//                .stream()
//                .map((authority) -> new SimpleGrantedAuthority(authority.getAuthority().toString()))
//                .collect(Collectors.toSet());
//    }
//
//    public static UserDetailsImpl build(User user) {
//        return new UserDetailsImpl(user);
//    }
//
//
//
//    @Override
//    public String getPassword() {
//        return user.getPasswordHash();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getDisplayName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return user.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return user.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return user.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return user.isEnabled();
//    }
//}
