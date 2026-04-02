package com.zorvyn.finance_dashboard_backend.service;

import com.zorvyn.finance_dashboard_backend.dto.AuthResponseDto;
import com.zorvyn.finance_dashboard_backend.dto.LoginRequestDto;
import com.zorvyn.finance_dashboard_backend.entity.User;
import com.zorvyn.finance_dashboard_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponseDto(token);
    }
}