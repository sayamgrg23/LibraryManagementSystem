package com.youtubesb.librarymanagementsystem.Service;

import com.youtubesb.librarymanagementsystem.Entity.UserEntity;
import com.youtubesb.librarymanagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
