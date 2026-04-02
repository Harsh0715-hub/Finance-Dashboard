package com.zorvyn.finance_dashboard_backend.entity;



import com.zorvyn.finance_dashboard_backend.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;
}