package ua.com.foxminded.calculator.provider;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.calculator.validator.DivisionValidatorImpl;

class DivisionCalculatorTest {
   private DivisionCalculator calculator;
   
   @Test
   void calulateDivisionShouldDoNotRaiseException() {
      calculator = new DivisionCalculator(new DivisionValidatorImpl(), new DivisionMathProviderImpl(), new DivisionViewProviderImpl());
      
      assertDoesNotThrow(() -> calculator.calulateDivision(1, 1));
   }
   
   @Test
   void calculateShouldThrowExceptionIfDivisorEquals0() {
      calculator = new DivisionCalculator(new DivisionValidatorImpl(), new DivisionMathProviderImpl(), new DivisionViewProviderImpl());
      
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         calculator.calulateDivision(1, 0);
      });

      assertEquals("The second part of the condition during division cannot be equal to zero.", exception.getMessage());
   }
}
