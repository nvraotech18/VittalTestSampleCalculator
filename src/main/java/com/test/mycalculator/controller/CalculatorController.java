package com.test.mycalculator.controller;


import com.test.mycalculator.operation.OperationType;
import com.test.mycalculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    Calculator calculator;
    @GetMapping
    public Number calculate(@RequestParam("operationType")OperationType operationType, @RequestParam("num1") Number num1, @RequestParam("num2") Number num2) {
        return calculator.calculate(operationType, num1, num2);
    }
}
