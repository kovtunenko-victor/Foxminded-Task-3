package ua.com.foxminded.calculator.divider;

import ua.com.foxminded.calculator.Condition;

class DivisionCondition implements Condition {
   private final int dividend;
   private final int divider;

   public DivisionCondition(int dividend, int divider) {
      this.dividend = dividend;
      this.divider = divider;
   }

   @Override
   public int getConditionFirstPart() {
      return dividend;
   }

   @Override
   public int getConditionSecondPart() {
      return divider;
   }
}
