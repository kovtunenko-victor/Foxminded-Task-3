package ua.com.foxminded.calculator.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivisionValidatorImplTest {
   private DivisionValidatorImpl validator = new DivisionValidatorImpl();

   @Test
   void calculateShouldThrowExceptionIfDivisorEquals0() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
         validator.validate(0);
      });

      assertEquals("The second part of the condition during division cannot be equal to zero.", exception.getMessage());
   }
   
   @Test
   void calculateShouldDoNotRaiseException() {
      assertDoesNotThrow(() -> validator.validate(1));
   }
}
