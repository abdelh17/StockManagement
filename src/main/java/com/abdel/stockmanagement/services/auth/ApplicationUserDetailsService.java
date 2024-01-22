//package com.abdel.stockmanagement.services.auth;
//
//import com.abdel.stockmanagement.domain.dto.UserDto;
//import com.abdel.stockmanagement.domain.entities.auth.ExtendedUser;
//import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
//import com.abdel.stockmanagement.exceptions.ErrorCodes;
//import com.abdel.stockmanagement.repositories.UserRepository;
//import com.abdel.stockmanagement.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class ApplicationUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserDto userDto = userService.findByEmail(email);
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        userDto.getRole().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
//
//        return new ExtendedUser(userDto.getEmail(), userDto.getPassword(), userDto.getCompany().getId(), authorities);
//    }
//}
