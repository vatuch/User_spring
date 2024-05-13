package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
}