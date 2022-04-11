package com.auth.Autherication.controller;

import com.auth.Autherication.model.AuthDto;
import com.auth.Autherication.model.JWTRequest;
import com.auth.Autherication.model.UserDto;
import com.auth.Autherication.model.UserWithOutPassword;
import com.auth.Autherication.service.ServiceAuth;
import com.auth.Autherication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ServiceAuth authService;

    @PostMapping("/auth/login")
    public ResponseEntity<AuthDto> login(@RequestBody JWTRequest jwtRequest) throws Exception {
        return new ResponseEntity<>(authService.login(jwtRequest), HttpStatus.OK);
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<UserWithOutPassword> register( @Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(authService.signup(userDto), HttpStatus.OK);
    }



}
