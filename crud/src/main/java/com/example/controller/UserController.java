package com.example.controller;

import com.example.db.User;
import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Gaurav.Bhoparia on 7/6/2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO findOne(@PathVariable Long id){
        User user = userService.findOne(id);
        return user!=null?new UserDTO(user):null;
    }

    @GetMapping
    public List<UserDTO> list(){
        List<User> users = userService.list();
        return users!=null ? users.stream().map(UserDTO :: new).collect(Collectors.toList()):null;
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){
        return new UserDTO(userService.save(userDTO.toEntity()));
    }

    @PutMapping("/{id}")
        public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return new UserDTO(userService.save(userDTO.toEntity(userService.findOne(id))));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
