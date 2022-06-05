package com.dlc.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigInteger;
import java.util.*;

import javax.persistence.*;

//@Entity
//@Table
//public class User {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Id
//    private BigInteger id;
//    private String displayName;
//    @JsonIgnore
//    private String passwordHash;
//    private String email;
//    private boolean enabled;
//    private boolean accountNonExpired;
//    private boolean credentialsNonExpired;
//    private boolean accountNonLocked;
//    private Date createdOn;
//    private Date lastLogin;
//
////    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JoinTable(
////            name = "user_authorities",
////            joinColumns = { @JoinColumn(name = "user_id") },
////            inverseJoinColumns = { @JoinColumn(name = "authority_id") }
////    )
//////    @Fetch(value = FetchMode.SELECT)
//////    private Set<Authorities> authorities = new HashSet<>();
//
//    public User() {
//
//    }
//
//    public void setId(BigInteger id) {
//        this.id = id;
//    }
//
//    public BigInteger getId() {
//        return id;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setPasswordHash(String password) {
//        this.passwordHash = passwordEncoder.encode(password);
//    }
//
//    public String getPasswordHash() {
//        return passwordHash;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
//
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
//
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
//
//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    public Date getLastLogin() {
//        return lastLogin;
//    }
//
//    public void setLastLogin(Date lastLogin) {
//        this.lastLogin = lastLogin;
//    }
//
//    public Set<Authorities> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Set<Authorities> authorities) {
//        this.authorities = authorities;
//    }
//}
