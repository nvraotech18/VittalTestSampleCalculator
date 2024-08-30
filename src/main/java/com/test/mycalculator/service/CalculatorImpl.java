package com.test.mycalculator.service;

import com.test.mycalculator.operation.IOperation;
import com.test.mycalculator.operation.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {
    // for chain calculation
    private Number initialNumber;
    @Autowired
    OperationBeanFactory operationBeanFactory;

    @Override
    public Number calculate(OperationType operationType, Number num1, Number num2) {
        IOperation operation = operationBeanFactory.getOperationBean(operationType);
        return operation.calculate(num1,num2);
    }

    public void chainCalculate(OperationType operationType, Number num1) {
        if(initialNumber != null) {
            this.initialNumber = calculate(operationType, this.initialNumber, num1);
        }else {
            System.out.println("please set the initial number");
        }

    }
    // getResult() to be called to get the chain operation result
    public Number getResult() {
        return initialNumber;
    }
    // setInitialNumber() to be called first to call the chainCalculator
    public void setInitialNumber(Number initialNumber) {
        this.initialNumber = initialNumber;
    }

}
