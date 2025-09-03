package com.atthahara.dayflow.controller;

import com.atthahara.dayflow.dto.UserLoginDTO;
import com.atthahara.dayflow.dto.UserRegisterDTO;
import com.atthahara.dayflow.model.User;
import com.atthahara.dayflow.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDTO dto) {
        return userService.register(dto);
}

    @PostMapping("/login")
    public ResponseEntity<String> login(UserLoginDTO dto) {
    // sementara hanya return success
    return ResponseEntity.ok("Login berhasil!");
}

    }
