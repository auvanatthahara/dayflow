package com.atthahara.dayflow.controller;

import com.atthahara.dayflow.dto.UserLoginDTO;
import com.atthahara.dayflow.dto.UserRegisterDTO;
import com.atthahara.dayflow.model.User;
import com.atthahara.dayflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO dto) {
        try {
            User user = userService.register(dto);
            return ResponseEntity.ok("User registered: " + user.getUsername());
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO dto) {
        boolean success = userService.login(dto);
        if(success) return ResponseEntity.ok("Login successful");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
