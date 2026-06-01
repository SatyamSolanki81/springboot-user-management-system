package com.crud.Model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name = "user_detail")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String userName;
    @Column(unique = true)
    String userEmail;
    @Column(nullable = false)
    String userPassword;
    @Column(unique = true)
    String mobileNumber;
    String address;
    @Column(name = "Date&Time")
    private LocalDateTime registeredAt;
}
