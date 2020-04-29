package ua.com.foxminded.calculator.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.calculator.domain.DivisionStep;

class DivisionMathProviderImplTest {
   DivisionMathProviderImpl mathProvider = new DivisionMathProviderImpl();
   
   @Test
   void provideMathCalculationShouldReturnTreeStepsIfDividendEquals4096AndDivisorEquals16() {
      int expectedSteps = 3;
      
      int expectedQuotient = 256;
      
      List<DivisionStep> actualSteps = mathProvider.provideMathCalculation(4096, 16);
      
      int actualQuotient = getQuotient(actualSteps);
      
      assertEquals(expectedSteps, actualSteps.size());
      
      assertEquals(expectedQuotient, actualQuotient);
   }
   
   @Test
   void provideMathCalculationShouldReturnSixStepsIfDividendEquals5446560AndDivisorEquals7() {
      int expectedSteps = 6;
      
      int expectedQuotient = 778080;
      
      List<DivisionStep> actualSteps = mathProvider.provideMathCalculation(5446560, 7);
      
      int actualQuotient = getQuotient(actualSteps);
      
      assertEquals(expectedSteps, actualSteps.size());
      
      assertEquals(expectedQuotient, actualQuotient);
   }
   
   @Test
   void provideMathCalculationShouldReturnOneStepIfDividendEqualsDivisor() {
      int expectedSteps = 1;
      
      int expectedQuotient = 1;
      
      List<DivisionStep> actualSteps = mathProvider.provideMathCalculation(5446560, 5446560);
      
      int actualQuotient = getQuotient(actualSteps);
      
      assertEquals(expectedSteps, actualSteps.size());
      
      assertEquals(expectedQuotient, actualQuotient);
   }
   
   @Test
   void provideMathCalculationShouldReturnInTreedStepQuotientDigitEquals8IfDividendEquals234002342AndDivisorEquals9425() {
      int expected = 8;
      
      List<DivisionStep> actual = mathProvider.provideMathCalculation(234002342, 9425);

      assertEquals(expected, actual.get(2).getQuotientDigit());
   }
   
   private int getQuotient(List<DivisionStep> steps) {
      StringBuilder quotient = new StringBuilder();
      
      for(DivisionStep step : steps) {
         quotient.append(step.getQuotientDigit());
      }
      
      return Integer.parseInt(quotient.toString());
   }
}
