//package com.abdel.stockmanagement.controllers;
//
//import com.abdel.stockmanagement.controllers.api.AuthenticationApi;
//import com.abdel.stockmanagement.domain.dto.auth.AuthenticationRequest;
//import com.abdel.stockmanagement.domain.dto.auth.AuthenticationResponse;
//import com.abdel.stockmanagement.services.auth.ApplicationUserDetailsService;
//import com.abdel.stockmanagement.utils.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class AuthenticationController implements AuthenticationApi {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private ApplicationUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.getUsername(),
//                        authenticationRequest.getPassword())
//        );
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
//
//    }
//
//}
