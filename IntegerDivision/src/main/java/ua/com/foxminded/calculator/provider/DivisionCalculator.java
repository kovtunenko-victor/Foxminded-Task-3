package ua.com.foxminded.calculator.provider;

import java.util.List;

import ua.com.foxminded.calculator.domain.DivisionStep;
import ua.com.foxminded.calculator.validator.DivisionValidator;

public class DivisionCalculator {
   private final DivisionValidator validator;
   
   private final DivisionMathProvider mathProvider;
   
   private final DivisionViewProvider viewProvider;

   public DivisionCalculator(DivisionValidator validator, DivisionMathProvider mathProvider,
         DivisionViewProvider viewProvider) {
       this.validator = validator;
       this.mathProvider = mathProvider;    
       this.viewProvider = viewProvider;
   }

   public String calulateDivision(int dividend, int divisor) {
       validator.validate(divisor);

       final List<DivisionStep> steps = mathProvider.provideMathCalculation(dividend, divisor);

       return viewProvider.provideDivisionView(steps, dividend, divisor);
   }
}
