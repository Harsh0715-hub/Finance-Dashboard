package com.zorvyn.finance_dashboard_backend.service;

import com.zorvyn.finance_dashboard_backend.dto.UserRequestDto;
import com.zorvyn.finance_dashboard_backend.dto.UserResponseDto;
import com.zorvyn.finance_dashboard_backend.entity.User;
import com.zorvyn.finance_dashboard_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(dto.getRole())
                .active(dto.isActive())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .active(savedUser.isActive())
                .build();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}