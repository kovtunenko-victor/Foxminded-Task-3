package ua.com.foxminded.calculator.divider;

import ua.com.foxminded.calculator.Condition;
import ua.com.foxminded.calculator.IntegerCalculator;

class IncomplitePrivate {
   private int value;
   private int cursor;

   public IncomplitePrivate() {
      value = 0;
      cursor = 0;
   }

   public IncomplitePrivate(IncomplitePrivate incPriv) {
      value = incPriv.getValue();
      cursor = incPriv.getCursor();
   }

   public void setValue(int value) {
      this.value = value;
   }

   public int getValue() {
      return value;
   }

   public void setCursor(int cursor) {
      this.cursor = cursor;
   }

   public int getCursor() {
      return cursor;
   }
}

public class IntegerDivision implements IntegerCalculator {
   private static final String CHAR_SEPARATOR = "|";
   
   @Override
   public String calculate(Condition condition) {
      IncomplitePrivate incPriv = getIncomplitePrivate(condition, new IncomplitePrivate(), 0);
      
      return "";
   }

   private IncomplitePrivate getIncomplitePrivate(Condition condition, IncomplitePrivate prevIncPriv, int difference) {
      IncomplitePrivate newIncPriv = new IncomplitePrivate(prevIncPriv);
      StringBuilder desiredValue = new StringBuilder();
      
      if(difference > 0) {
         desiredValue.append(String.valueOf(difference));
      }
      
      do {
         desiredValue.append(String.valueOf(condition.getConditionFirstPart()).split(CHAR_SEPARATOR)[newIncPriv.getCursor()]);
         newIncPriv.setCursor(newIncPriv.getCursor() + 1);
      } while (Integer.valueOf(desiredValue.toString()) >= condition.getConditionSecondPart() || Integer.valueOf(desiredValue.toString()) == 0);
      
      newIncPriv.setValue(Integer.valueOf(desiredValue.toString()));
         
      return newIncPriv;
   }
   
   private int getResultCharCount(int incPrivValue, int dividend) {
      int charCount = 0;
      
      charCount =  String.valueOf(dividend).length() - String.valueOf(incPrivValue).length() + 1;
      
      return charCount;
   }
   
   public static void main(String arg) {
      
   }
}
