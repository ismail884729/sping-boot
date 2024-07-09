package com.ismail.sports.service;

import com.ismail.sports.model.User;
import com.ismail.sports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public boolean deleteUserById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }

    public Optional<User> updateUser(Long userId, User newUserDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(newUserDetails.getUsername());
            user.setPassword(newUserDetails.getPassword());
            return userRepository.save(user);
        });
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
