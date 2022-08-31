package com.mariiakushel.task.details;

import com.mariiakushel.task.enumeration.UserRole;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.entity.Employee;
import com.mariiakushel.task.repository.entity.User;
import com.mariiakushel.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = repository.findByUsernameAndActive(username, true)
                    .orElseThrow(() -> new CustomException("user not found username=" + username, HttpStatus.NOT_FOUND));
            Employee emp = user.getEmployee();
            UserRole role = emp != null ? emp.getPosition().getRole() : UserRole.ROLE_ADMIN;
            Long employeeId = emp != null ? emp.getId() : null;
            return new CustomUserDetails(user.getUsername(), user.getPassword(), role, employeeId);
        } catch (CustomException e) {
            throw new UsernameNotFoundException("");
        }
    }
}
