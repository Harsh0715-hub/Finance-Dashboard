package com.zorvyn.finance_dashboard_backend.controller;

import com.zorvyn.finance_dashboard_backend.dto.UserRequestDto;
import com.zorvyn.finance_dashboard_backend.dto.UserResponseDto;
import com.zorvyn.finance_dashboard_backend.entity.User;
import com.zorvyn.finance_dashboard_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}