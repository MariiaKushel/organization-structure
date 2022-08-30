package com.mariiakushel.task.details;

import com.mariiakushel.task.enumeration.UserRole;
import com.mariiakushel.task.exception.CustomException;
import com.mariiakushel.task.repository.entity.User;
import com.mariiakushel.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = repository.findByUsernameAndActive(username, true)
                    .orElseThrow(() -> new CustomException("user not found username=" + username, HttpStatus.NOT_FOUND));
            UserRole role = user.getEmployee().getPosition().getRole();
            Long employeeId = user.getEmployee().getId();
            return new CustomUserDetails(user.getUsername(), user.getPassword(), role, employeeId);
        } catch (CustomException e) {
            throw new UsernameNotFoundException("");
        }
    }
}
