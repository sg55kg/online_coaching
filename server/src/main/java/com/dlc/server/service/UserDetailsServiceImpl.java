package com.dlc.server.service;

import com.dlc.server.model.User;
import com.dlc.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsImpl userDetails;

    @Override
    public UserDetails loadUserByUsername(String displayName) throws UsernameNotFoundException {
        User user = userRepository.findByDisplayName(displayName)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user with username: " + displayName));

        return userDetails.build(user);
    }

    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new Error("Could not find user with emailL " + email));

        return userDetails.build(user);
    }

    public Boolean existsByDisplayName(String displayName) {
        User user = userRepository.findByDisplayName(displayName)
                .orElse(null);
        return user != null;
    }

    public Boolean existsByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElse(null);
        return user != null;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }


    public void updateUser(User user) {

    }


    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }


    public void changePassword(String oldPassword, String newPassword) {

    }


    public boolean userExists(String username) {
        return false;
    }
}
