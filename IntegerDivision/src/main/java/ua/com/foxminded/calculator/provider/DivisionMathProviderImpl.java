package ua.com.foxminded.calculator.provider;

import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.calculator.domain.DivisionStep;

public class DivisionMathProviderImpl implements DivisionMathProvider {
   private static final String CHAR_SEPARATOR = "|";
   private static final String ZERO = "0";

   @Override
   public List<DivisionStep> provideMathCalculation(int dividend, int divisor) {
      final List<DivisionStep> steps = new ArrayList<>();

      int incompliteQuotient = getIncompliteQuotient(dividend, divisor);

      int amountCharactersQuotient = getAmountCharactersQuotient(incompliteQuotient, dividend);

      int quotientDigit = 0;

      int intermediateValue = 0;

      int difference = 0;

      int quotientIterator = 0;

      while (quotientIterator < amountCharactersQuotient) {
         quotientDigit = getQuotientDigit(incompliteQuotient, divisor);

         intermediateValue = getIntermediateValue(quotientDigit, divisor);

         difference = getDifference(incompliteQuotient, intermediateValue);

         steps.add(DivisionStep.builder()
               .withIncompliteQuotient(incompliteQuotient)
               .withIntermediateValue(intermediateValue)
               .withDifference(difference)
               .withQuotientDigit(quotientDigit)
               .build());

         quotientIterator++;

         int nextDividendDigit = getNextDividendDigit(dividend, divisor, quotientIterator);

         int newIncompliteQuotient = Integer.parseInt(String.valueOf(difference) + String.valueOf(nextDividendDigit));

         while (newIncompliteQuotient < divisor) {
            if (quotientIterator < amountCharactersQuotient) {
               quotientDigit = 0;

               steps.add(DivisionStep.builder()
                     .withIncompliteQuotient(newIncompliteQuotient)
                     .withIntermediateValue(0)
                     .withDifference(0)
                     .withQuotientDigit(quotientDigit)
                     .build());

               quotientIterator++;

               nextDividendDigit = getNextDividendDigit(dividend, divisor, quotientIterator);

               newIncompliteQuotient = Integer
                     .parseInt(String.valueOf(newIncompliteQuotient) + String.valueOf(nextDividendDigit));

            } else {
               break;
            }
         }

         incompliteQuotient = newIncompliteQuotient;
      }

      return steps;
   }

   private int getIncompliteQuotient(int dividend, int divisor) {
      StringBuilder incompliteQuotientValue = new StringBuilder();

      String[] dividendDigits = String.valueOf(dividend).split(CHAR_SEPARATOR);

      for (int i = 0; i < dividendDigits.length; i++) {
         incompliteQuotientValue.append(dividendDigits[i]);

         if (Integer.parseInt(incompliteQuotientValue.toString()) >= divisor) {
            break;
         }
      }

      return Integer.parseInt(incompliteQuotientValue.toString());
   }

   private int getAmountCharactersQuotient(int incompliteQuotient, int dividend) {
      return String.valueOf(dividend).length() - String.valueOf(incompliteQuotient).length() + 1;
   }

   private Integer getQuotientDigit(int incompliteQuotient, int divisor) {
      int desiredValue = 0;
      int tempValue = 0;

      while (incompliteQuotient >= tempValue) {
         tempValue = divisor * desiredValue++;
      }
      desiredValue = desiredValue - 2;

      return desiredValue;
   }

   private int getIntermediateValue(int quotientDigit, int divisor) {
      return quotientDigit * divisor;
   }

   private int getDifference(int incompliteQuotient, int intermediateValue) {
      return incompliteQuotient - intermediateValue;
   }

   private int getNextDividendDigit(int dividend, int divisor, int quotientIterator) {
      int incompliteQuotient = getIncompliteQuotient(dividend, divisor);

      String[] dividendDigits = String.valueOf(dividend).replaceFirst(String.valueOf(incompliteQuotient), "")
            .split(CHAR_SEPARATOR);

      if (dividend < divisor) {
         return 0;
      } else {
         if (dividendDigits.length > quotientIterator - 1) {
            return getNextDividendDigitIntegerValue(dividendDigits[quotientIterator - 1]);
         } else {
            return getNextDividendDigitIntegerValue(dividendDigits[dividendDigits.length - 1]);
         }
      }
   }

   private int getNextDividendDigitIntegerValue(String dividendDigit) {
      return Integer.parseInt(dividendDigit.isEmpty() ? ZERO : dividendDigit);
   }
}
