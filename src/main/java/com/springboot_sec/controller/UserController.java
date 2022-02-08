package com.springboot_sec.controller;

import com.springboot_sec.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    private static final List<User> USERS = Arrays.asList(new User(1,"Misha","Petrov"),
    new User(2,"Lena", "Caplina"),  new User(3, "Nicita", "Zavgorodko"));


    @GetMapping("{userId}")
    public User getAllUsers(@PathVariable("userId") Integer userId){

        return USERS.stream()
                .filter(users -> users.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("usersId is not find"));

    }

}
