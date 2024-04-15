package com.example.dto;

import com.example.db.User;
import com.example.util.CustomTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by Gaurav.Bhoparia on 7/6/2017.
 */
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    @JsonSerialize(using = CustomTimeSerializer.class)
    private Date dob;

    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.dob = user.getDob();
    }

    public User toEntity() {return toEntity(new User());}

    public User toEntity(User user) {
        user.setFirstName(this.getFirstName());
        user.setLastName(this.getLastName());
        user.setUsername(this.getUsername());
        user.setDob(this.getDob());
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
