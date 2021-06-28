package com.example.spring.aspect.demo.service;

import org.springframework.stereotype.Service;

import com.example.spring.aspect.demo.aspect.annotation.Loggable;
import com.example.spring.aspect.demo.model.Circle;
import com.example.spring.aspect.demo.model.Triangle;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ShapeService {

    private final Circle circle;
    private final Triangle triangle;

    public void draw() {
        circle.setName("Circle");
        System.out.println(circle.getName());
    }

    @Loggable
    public void drawTriangle() {
        System.out.println(triangle.draw(triangle.getName()));
    }

    public void refreshTriangle(Integer delay) {
        triangle.refresh(delay);
    }
}
