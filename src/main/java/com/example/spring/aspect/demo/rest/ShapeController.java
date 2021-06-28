package com.example.spring.aspect.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.aspect.demo.service.ShapeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shape")
public class ShapeController {

    private final ShapeService shapeService;

    @GetMapping("/circle")
    public void drawCircle() {
        shapeService.draw();
    }

    @GetMapping("/triangle")
    public void drawTriangle() {
        shapeService.drawTriangle();
    }

    @GetMapping("/triangle/refresh/{delay}")
    public void refreshTriangle(@PathVariable("delay") Integer delay) {
        shapeService.refreshTriangle(delay);
    }
}

