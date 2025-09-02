package com.atthahara.dayflow.service;

import com.atthahara.dayflow.dto.UserLoginDTO;
import com.atthahara.dayflow.dto.UserRegisterDTO;
import com.atthahara.dayflow.model.User;
import com.atthahara.dayflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserRegisterDTO dto) {
        if(userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());

        return userRepository.save(user);
    }

    public boolean login(UserLoginDTO dto) {
        return userRepository.findByUsername(dto.getUsername())
                .map(user -> passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                .orElse(false);
    }
}
