package com.cimt.myspringproject.controller;

import com.cimt.myspringproject.entity.GCDRequest;
import com.cimt.myspringproject.service.MyMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * MyMathController provides rest endpoints for math operations
 * Author: Harsh, Kshitij
 * Date: 05 June 2024
 */
@RestController
public class MyMathController {

    @Autowired
    private MyMathService mathService;

    /**
     * This method calculates the Fibonacci number at a given position.
     *
     * @param position the position in the Fibonacci sequence
     * @return the Fibonacci mumber at the specified position
     */
    @GetMapping("/fibonacci/{position}")
    public int getFibonacci(@PathVariable int position) {
        return mathService.calculateFibonacci(position);
    }

    /**
     * This method calculates the Greatest Common Divisor (GCD) of two numbers.
     *
     * @param request a JSON formatted object containing "num1" and "num2"
     * @return the GCD value of the two numbers
     */
    @PostMapping("/gcd")
    public int calculateGCD(@RequestBody GCDRequest request) {
        return mathService.calculateGCD(request.getNum1(), request.getNum2());
    }

}
