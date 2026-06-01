package com.crud.service;

import com.crud.Model.User;
import com.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Userservice {

 @Autowired
    private UserRepository userRepository;

    public User registerUserDetail(User user) {

        user.setRegisteredAt(LocalDateTime.now());
        return  userRepository.save(user);
    }

    public User updateUserDetail(String id, User user) {

        /* internal working
               User existingUser = null;

Optional<User> optionalUser = userRepository.findById(id);

if(optionalUser.isPresent()) {
    existingUser = optionalUser.get();
} else {
    throw new RuntimeException("user not exist..");
}
        */

        User exitingUser= userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("user not exist.."));

        exitingUser.setUserName(user.getUserName());
        exitingUser.setUserEmail(user.getUserEmail());
        exitingUser.setAddress(user.getAddress());
        exitingUser.setMobileNumber(user.getMobileNumber());

        return userRepository.save(exitingUser);
    }

    public List<User> getAllUserDetail() {

        return userRepository.findAll();
    }

    public String deleteUserDetail(String username) {

        User userName = userRepository.findByUserName(username);

        if(userName==null)
        {
            throw new RuntimeException("user not found....");
        }
        userRepository.delete(userName);
        return "user delete Sucessfully...";
    }

    public User getUserDetail(String username) {

        User user= userRepository.findByUserName(username);

        if(user == null)
        {
            throw new RuntimeException("user not found...");
        }
        return user;
    }
}
