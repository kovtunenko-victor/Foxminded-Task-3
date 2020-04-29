package ua.com.foxminded.calculator.provider;

import java.util.List;

import ua.com.foxminded.calculator.domain.DivisionStep;

public interface DivisionViewProvider {
   String provideDivisionView(List<DivisionStep> steps, int dividend, int divisor);
}
