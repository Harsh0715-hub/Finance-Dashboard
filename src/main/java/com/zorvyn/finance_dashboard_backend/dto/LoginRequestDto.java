package com.zorvyn.finance_dashboard_backend.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
