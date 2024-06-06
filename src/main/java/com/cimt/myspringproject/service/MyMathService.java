package com.cimt.myspringproject.service;

import org.springframework.stereotype.Service;

/**
 * MyMathService provides math operations.
 * Author: Harsh, Kshitij
 * Date: 05 June 2024
 */
@Service
public class MyMathService {

    public int calculateFibonacci(int position) {
        if (position == 0) {
            return 0;
        }
        int num1 = 0;
        int num2 = 1;
        for (int i = 2; i <= position; i++) {
            int temp = num2;
            num2 += num1;
            num1 = temp;
        }
        return num2;
    }

    public int calculateGCD(int num1, int num2) {
        System.out.println("Here");
        if (num1 == 0) {
            return num2;
        }else if(num2 == 0){
            return num1;
        }
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
