package com.zorvyn.finance_dashboard_backend.dto;

import com.zorvyn.finance_dashboard_backend.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private Role role;
    private boolean active;
}