package com.zorvyn.finance_dashboard_backend.dto;

import com.zorvyn.finance_dashboard_backend.enums.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private Role role;
    private boolean active;
}
