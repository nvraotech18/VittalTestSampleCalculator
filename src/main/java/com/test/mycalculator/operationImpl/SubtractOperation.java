package com.test.mycalculator.operationImpl;

import com.test.mycalculator.operation.IOperation;
import com.test.mycalculator.operation.OperationType;
import com.test.mycalculator.operation.OpertionBeanHandler;
import org.springframework.stereotype.Component;

@Component
@OpertionBeanHandler(operationType = OperationType.SUBTRACT)
public class SubtractOperation implements IOperation {
    @Override
    public Number calculate(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
