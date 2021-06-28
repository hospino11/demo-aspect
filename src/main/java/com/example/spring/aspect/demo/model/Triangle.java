package com.example.spring.aspect.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Triangle {

    private String name;

    public String getName() {
        return this.name;
    }

    public String draw(String name) {
        return "Drawing a triangle called: " + name;
    }

    public void refresh(int delay) {
        System.out.println("Refreshing triangle on " + delay + " seconds.");
    }
}
