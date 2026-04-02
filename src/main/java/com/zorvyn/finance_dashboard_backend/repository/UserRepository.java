package com.zorvyn.finance_dashboard_backend.repository;



import com.zorvyn.finance_dashboard_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
