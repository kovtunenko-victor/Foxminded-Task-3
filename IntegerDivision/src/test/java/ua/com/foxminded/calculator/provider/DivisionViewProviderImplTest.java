package ua.com.foxminded.calculator.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.calculator.domain.DivisionStep;

class DivisionViewProviderImplTest {
   DivisionViewProviderImpl viewProvider = new DivisionViewProviderImpl();
   static final String BREAK = "\r\n";
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsOne() {
      String expected = "78945 4"     + BREAK + 
                        "4     19736" + BREAK + 
                        "38"          + BREAK + 
                        "36"          + BREAK + 
                        " 29"         + BREAK + 
                        " 28"         + BREAK + 
                        "  14"        + BREAK + 
                        "  12"        + BREAK + 
                        "   25"       + BREAK + 
                        "   24"       + BREAK + 
                        "    1";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 4);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 4);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsTwo() {
      String expected = "78945 41"   + BREAK + 
                        "41    1925" + BREAK + 
                        "379"        + BREAK + 
                        "369"        + BREAK + 
                        " 104"       + BREAK + 
                        "  82"       + BREAK + 
                        "  225"      + BREAK + 
                        "  205"      + BREAK + 
                        "   20";
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 41);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 41);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsTree() {
      String expected = "78678 423" + BREAK + 
                        "423   186" + BREAK + 
                        "3637"      + BREAK + 
                        "3384"      + BREAK + 
                        " 2538"     + BREAK + 
                        " 2538"     + BREAK + 
                        "    0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78678, 423);
      
      String actual = viewProvider.provideDivisionView(steps, 78678, 423);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsFour() {
      String expected = "78945 4234" + BREAK + 
                        "4234  18"   + BREAK + 
                        "36605"      + BREAK + 
                        "33872"      + BREAK + 
                        " 2733";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 4234);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 4234);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsFive() {
      String expected = "78945 42345" + BREAK + 
                        "42345 1"     + BREAK + 
                        "36600";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 42345);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 42345);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void calculateShouldReturnColumnSolvedEquationIfDividendEqualsDivider() {
      String expected = "78945 78945" + BREAK + 
                        "78945 1"     + BREAK + 
                        "    0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 78945);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 78945);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendHasZero() {
      String expected = "100000 25"   + BREAK + 
                        "100    4000" + BREAK + 
                        "   0"        + BREAK + 
                        "   0"        + BREAK + 
                        "    0"       + BREAK + 
                        "    0"       + BREAK + 
                        "     0"      + BREAK + 
                        "     0"      + BREAK + 
                        "     0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(100000, 25);
      
      String actual = viewProvider.provideDivisionView(steps, 100000, 25);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividerMoreDividend() {
      String expected = "21 55" + BREAK + 
                        " 0 0"  + BREAK + 
                        "21";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(21, 55);
      
      String actual = viewProvider.provideDivisionView(steps, 21, 55);

      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendIsZero() {
      String expected = "0 55" + BREAK + 
                        "0 0"  + BREAK + 
                        "0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(0, 55);
      
      String actual = viewProvider.provideDivisionView(steps, 0, 55);

      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfQuotientHasZero() {
      String expected = "5446560 7"      + BREAK + 
                        "49      778080" + BREAK + 
                        " 54"            + BREAK + 
                        " 49"            + BREAK + 
                        "  56"           + BREAK + 
                        "  56"           + BREAK + 
                        "    56"         + BREAK + 
                        "    56"         + BREAK + 
                        "      0"        + BREAK + 
                        "      0"        + BREAK + 
                        "      0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(5446560, 7);
      
      String actual = viewProvider.provideDivisionView(steps, 5446560, 7);
      
      assertEquals(expected, actual);
   }
}
