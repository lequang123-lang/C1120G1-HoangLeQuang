package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public float calculate(float firstOperand, float secondOperand, char operator ){
        switch (operator){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new ArithmeticException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
