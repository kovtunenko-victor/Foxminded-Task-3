package ua.com.foxminded.calculator;

import ua.com.foxminded.calculator.provider.DivisionCalculator;
import ua.com.foxminded.calculator.provider.DivisionMathProviderImpl;
import ua.com.foxminded.calculator.provider.DivisionTableViewProvider;
import ua.com.foxminded.calculator.reader.ConsoleReader;
import ua.com.foxminded.calculator.reader.ConsoleReaderImpl;
import ua.com.foxminded.calculator.validator.DivisionValidatorImpl;

public class DivisionConsoleApplication {
   public static void main(String[] args) {
      ConsoleReader reader = new ConsoleReaderImpl();
      
      int dividend = reader.readIntValue();
      
      int divisor  = reader.readIntValue();
      
      DivisionCalculator calculator = new DivisionCalculator(new DivisionValidatorImpl(), new DivisionMathProviderImpl(), new DivisionTableViewProvider());
      
      String result = calculator.calulateDivision(dividend, divisor);
      
      System.out.println(result);    
   }
}
