package com.crud.controller;
import com.crud.Model.User;
import com.crud.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Userservice userservice;

    @PostMapping("/insert")
    public User insertUser(@RequestBody User user)
    {
        return userservice.registerUserDetail(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable String id,@RequestBody User user)
    {
        return userservice.updateUserDetail(id, user);
    }

    @GetMapping("/getAll")
     public List<User> getAllUser()
    {
        return userservice.getAllUserDetail();
    }

    @GetMapping("/getUser/{username}")
    public User getUser(@PathVariable String username)
    {
        return userservice.getUserDetail(username);
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username)
    {
        return userservice.deleteUserDetail(username);
    }
}
