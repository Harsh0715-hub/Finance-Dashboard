package com.zorvyn.finance_dashboard_backend.controller;

import com.zorvyn.finance_dashboard_backend.dto.AuthResponseDto;
import com.zorvyn.finance_dashboard_backend.dto.LoginRequestDto;
import com.zorvyn.finance_dashboard_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }
}