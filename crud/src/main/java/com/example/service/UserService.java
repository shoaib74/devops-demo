package com.example.service;

import com.example.db.User;
import com.example.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gaurav.Bhoparia on 7/6/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = Logger.getLogger(UserService.class);

    public List<User> list() {
        List<User> users = userRepository.findAll();
        logger.debug(users);
        return users;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}
