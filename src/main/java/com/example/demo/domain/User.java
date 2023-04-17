package com.example.demo.domain;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private int age;
    private String email;
}
