package com.BitwareTecnicaF.BitwareTecnicaF.users.services;

import com.BitwareTecnicaF.BitwareTecnicaF.users.models.User;
import com.BitwareTecnicaF.BitwareTecnicaF.users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserWithRoles(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.getRoles().size();
        return user;
    }

    public User createUser(User user) {
        try {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            return userRepository.save(user);

        }catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during user creation", e);
        }
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
