package com.abdel.stockmanagement.services.auth;

import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.abdel.stockmanagement.domain.entities.User user = userRepository.findUserByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("No user was found with this email.", ErrorCodes.USER_NOT_FOUND)
        );

        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }
}
