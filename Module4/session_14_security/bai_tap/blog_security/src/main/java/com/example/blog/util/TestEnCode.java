package com.example.blog.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEnCode {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("abc");
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }
}
