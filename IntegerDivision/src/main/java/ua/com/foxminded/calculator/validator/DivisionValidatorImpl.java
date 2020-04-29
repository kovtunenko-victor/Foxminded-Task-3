package ua.com.foxminded.calculator.validator;

public class DivisionValidatorImpl implements DivisionValidator {
   @Override
   public void validate(int divider) {
      if (divider == 0) {
         throw new IllegalArgumentException(
               "The second part of the condition during division cannot be equal to zero.");
      }
   }
}
