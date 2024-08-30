package com.test.mycalculator;

import com.test.mycalculator.operation.OperationType;
import com.test.mycalculator.service.Calculator;
import com.test.mycalculator.service.CalculatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MycalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	Calculator calculator;

	@Test
	public void testAdd() {
		Number num1 = 20;
		Number num2 = 10;
		Number result = calculator.calculate(OperationType.ADD, num1, num2);
		System.out.println(result);
		Assertions.assertTrue(result.doubleValue() == (num1.doubleValue()+num2.doubleValue()));
	}

	@Test
	public void testSubtract() {
		Number num1 = 20;
		Number num2 = 10;
		Number result = calculator.calculate(OperationType.SUBTRACT, num1, num2);
		System.out.println(result);
		Assertions.assertTrue(result.doubleValue() == (num1.doubleValue()-num2.doubleValue()));
	}

	@Test
	public void testMultiply() {
		Number num1 = 20;
		Number num2 = 10;
		Number result = calculator.calculate(OperationType.MULTIPLY, num1, num2);
		System.out.println(result);
		Assertions.assertTrue(result.doubleValue() == (num1.doubleValue()*num2.doubleValue()));
	}

	@Test
	public void testDivide() {
		Number num1 = 20;
		Number num2 = 10;
		Number result = calculator.calculate(OperationType.DIVIDE, num1, num2);
		System.out.println(result);
		Assertions.assertTrue(result.doubleValue() == (num1.doubleValue()/num2.doubleValue()));
	}

}
