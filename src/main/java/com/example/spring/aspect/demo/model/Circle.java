package com.example.spring.aspect.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Circle {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
