package ua.com.foxminded.calculator.domain;

public class DivisionStep {
   private final int incompliteQuotient;
   
   private final int intermediateValue;
   
   private final int difference;
   
   private final int quotientDigit;
   
   public DivisionStep(Builder builder) {
      this.incompliteQuotient = builder.incompliteQuotient;      
      this.intermediateValue =  builder.intermediateValue;    
      this.difference =  builder.difference;  
      this.quotientDigit =  builder.quotientDigit;
  }
   
   public int getIncompliteQuotient() {
      return incompliteQuotient;
   }
   
   public int getIntermediateValue() {
      return intermediateValue;
   }
   
   public int getDifference() {
      return difference;
   }
   
   public int getQuotientDigit() {
      return quotientDigit;
   }
   
   public static Builder builder() {
      return new Builder();
   }
   
   public static class Builder {
      private int incompliteQuotient;
      
      private int intermediateValue;
      
      private int difference;
      
      private int quotientDigit;
      
      private Builder() { }
      
      public Builder withIncompliteQuotient(int incompliteQuotient) {
         this.incompliteQuotient = incompliteQuotient;
         return this;
      }
      
      public Builder withIntermediateValue(int intermediateValue) {
         this.intermediateValue = intermediateValue;
         return this;
      }
      
      public Builder withDifference(int difference) {
         this.difference = difference; 
         return this;
      }
      
      public Builder withQuotientDigit(int quotientDigit) {
         this.quotientDigit = quotientDigit;
         return this;
      }
      
      public DivisionStep build() {
         return new DivisionStep(this);
      }
   }
}
