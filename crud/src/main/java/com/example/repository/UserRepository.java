package com.example.repository;

import com.example.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Gaurav.Bhoparia on 7/6/2017.
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
