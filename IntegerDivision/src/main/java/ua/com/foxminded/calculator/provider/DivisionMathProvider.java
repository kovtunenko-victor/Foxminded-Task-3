package ua.com.foxminded.calculator.provider;

import java.util.List;

import ua.com.foxminded.calculator.domain.DivisionStep;

public interface DivisionMathProvider {
   List<DivisionStep> provideMathCalculation(int dividend, int divisor);
}
