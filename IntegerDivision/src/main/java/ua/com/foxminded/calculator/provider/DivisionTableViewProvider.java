package ua.com.foxminded.calculator.provider;

import java.util.List;

import ua.com.foxminded.calculator.domain.DivisionStep;

public class DivisionTableViewProvider implements DivisionViewProvider {
   private static final String SPACE_DELIMITER = " ";
   private static final String PREFIX = "_";
   private static final String VERTICAL_LINE = "|";
   private static final String HORIZONTAL_LINE = "-";

   @Override
   public String provideDivisionView(List<DivisionStep> steps, int dividend, int divisor) {
      StringBuilder result = new StringBuilder();

      StringBuilder quotient = new StringBuilder();

      int prevTabLength = 1;

      int quotentPosition = 0;

      int firstIntermediateValueLength = 0;

      String tabs = SPACE_DELIMITER;

      result.append(PREFIX).append(dividend).append(SPACE_DELIMITER).append(VERTICAL_LINE).append(divisor)
            .append("\r\n");

      for (int i = 0; i < steps.size(); i++) {
         if (getCondition(dividend, divisor, steps.get(i).getIntermediateValue(),
               steps.get(i).getIncompliteQuotient())) {
            if (i > 0) {
               result.append(tabs.replaceFirst(".$", PREFIX)).append(steps.get(i).getIncompliteQuotient())
                     .append("\r\n");
            }

            tabs = getCorrectTabLength(tabs, steps.get(i).getIncompliteQuotient(), steps.get(i).getIntermediateValue());

            result.append(tabs).append(steps.get(i).getIntermediateValue());

            if (i == 0) {
               quotentPosition = result.length();

               firstIntermediateValueLength = String
                     .valueOf(tabs + steps.get(i).getIntermediateValue() + SPACE_DELIMITER + VERTICAL_LINE).length();

               quotient.append(getFirstTabs(dividend, steps.get(i).getIntermediateValue(), tabs.length()))
                     .append(SPACE_DELIMITER).append(VERTICAL_LINE);
            }

            result.append("\r\n");

            result.append(tabs).append(getHorizontalLine(String.valueOf(steps.get(i).getIntermediateValue()).length()))
                  .append("\r\n");

            tabs = getTabs(steps.get(i).getIncompliteQuotient(), steps.get(i).getDifference(), prevTabLength);

            prevTabLength = tabs.length();
         }

         quotient.append(steps.get(i).getQuotientDigit());
      }

      if (steps.get(steps.size() - 1).getDifference() == 0) {
         tabs = tabs.substring(0, tabs.length() - 1);
      }

      result.append(tabs).append(steps.get(steps.size() - 1).getDifference());

      result.insert(quotentPosition, quotient.toString().replaceAll("[0-9]", HORIZONTAL_LINE));

      quotentPosition = quotentPosition + quotient.length() + firstIntermediateValueLength;

      result.insert(quotentPosition, quotient);

      return result.toString();
   }

   private String getTabs(int incompliteQuotient, int difference, int prevTabLength) {
      int tabLength = prevTabLength + String.valueOf(incompliteQuotient).length()
            - (difference == 0 ? 0 : String.valueOf(difference).length());

      return new String(new char[tabLength]).replace("\0", SPACE_DELIMITER);
   }

   private String getFirstTabs(int dividend, int intermediateValue, int tabsLength) {
      int tabLength = (1 - tabsLength) + String.valueOf(dividend).length()
            - (intermediateValue == 0 ? 1 : String.valueOf(intermediateValue).length());

      return new String(new char[tabLength]).replace("\0", SPACE_DELIMITER);
   }

   private String getHorizontalLine(int length) {
      return new String(new char[length]).replace("\0", HORIZONTAL_LINE);
   }

   private String getCorrectTabLength(String tabs, int incompliteQuotient, int intermediateValue) {
      StringBuilder correctTab = new StringBuilder(tabs);

      int correctLength = String.valueOf(incompliteQuotient).length() - String.valueOf(intermediateValue).length();

      correctTab.append(new String(new char[correctLength]).replace("\0", SPACE_DELIMITER));

      return correctTab.toString();
   }

   private boolean getCondition(int dividend, int divisor, int intermediateValue, int incompliteQuotient) {
      return intermediateValue >= divisor || incompliteQuotient == 0 || divisor > dividend;
   }
}
