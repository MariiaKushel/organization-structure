package com.mariiakushel.task.details;

import com.mariiakushel.task.enumeration.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

public class CustomUserDetails extends User {
    private Long employeeId;
    private UserRole role;

    public CustomUserDetails(String username, String password, UserRole role, Long employeeId) {
        super(username,
                password,
                true,
                true,
                true,
                true,
                Set.of(new SimpleGrantedAuthority(role.name())));
        this.role = role;
        this.employeeId = employeeId;
    }

    public String getRoleJWT() {
        return this.role.name();
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }
}
