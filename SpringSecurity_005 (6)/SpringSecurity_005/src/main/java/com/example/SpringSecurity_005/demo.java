package com.example.SpringSecurity_005;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class demo {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("password123"));
    }
}
