package com.example.averagecalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/average")
public class AverageController {

    @PostMapping
    public ResponseEntity<Double> calculateAverage(@RequestBody List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        double average = sum / numbers.size();

        return ResponseEntity.ok(average);
    }
}
