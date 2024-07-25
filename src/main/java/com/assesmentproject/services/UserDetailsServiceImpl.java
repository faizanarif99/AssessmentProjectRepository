package com.assesmentproject.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class.getSimpleName());

      @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        logger.info("Calling METHOD: loadUserByUsername(String username) ");
        try {
            if (username == null) {
                logger.info("User not found with username: " + username);
                throw new UsernameNotFoundException("User not found with username: " + username);
            } else if (username.equals("Faizan")){
                logger.info("User found with username: " + username);
                return new User("Faizan", "123", new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          throw new UsernameNotFoundException("User not found with username: " + username);
    }
}

