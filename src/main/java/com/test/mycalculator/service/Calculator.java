package com.test.mycalculator.service;

import com.test.mycalculator.operation.OperationType;

public interface Calculator {

    Number calculate(OperationType operationType, Number num1, Number num2);
}
