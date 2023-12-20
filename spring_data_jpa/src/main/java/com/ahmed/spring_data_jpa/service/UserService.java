package com.ahmed.spring_data_jpa.service;


import com.ahmed.spring_data_jpa.entity.User;
import com.ahmed.spring_data_jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User fetchUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> fetchUsers(Long id) {
        return userRepository.findAll();
    }

    public Boolean deleteUserById(Long id) {
        userRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
