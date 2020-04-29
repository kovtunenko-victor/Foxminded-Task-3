package ua.com.foxminded.calculator.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.calculator.domain.DivisionStep;

class DivisionTableViewProviderTest {
   DivisionTableViewProvider viewProvider = new DivisionTableViewProvider();
   
   static final String BREAK = "\r\n";
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsOne() {
      String expected = "_78945 |4"      + BREAK + 
                        " 4     |-----"  + BREAK + 
                        " -     |19736"  + BREAK + 
                        "_38"            + BREAK + 
                        " 36"            + BREAK + 
                        " --"            + BREAK + 
                        " _29"           + BREAK + 
                        "  28"           + BREAK + 
                        "  --"           + BREAK + 
                        "  _14"          + BREAK + 
                        "   12"          + BREAK + 
                        "   --"          + BREAK + 
                        "   _25"         + BREAK + 
                        "    24"         + BREAK +
                        "    --"         + BREAK +
                        "     1";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 4);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 4);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsTwo() {
      String expected = "_78945 |41"   + BREAK + 
                        " 41    |----" + BREAK + 
                        " --    |1925" + BREAK + 
                        "_379"         + BREAK + 
                        " 369"         + BREAK + 
                        " ---"         + BREAK + 
                        " _104"        + BREAK + 
                        "   82"        + BREAK + 
                        "   --"        + BREAK + 
                        "  _225"       + BREAK +
                        "   205"       + BREAK +
                        "   ---"       + BREAK +
                        "    20";
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 41);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 41);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsTree() {
      String expected = "_78678 |423" + BREAK + 
                        " 423   |---" + BREAK + 
                        " ---   |186" + BREAK + 
                        "_3637"       + BREAK + 
                        " 3384"       + BREAK + 
                        " ----"       + BREAK + 
                        " _2538"      + BREAK + 
                        "  2538"      + BREAK + 
                        "  ----"      + BREAK + 
                        "     0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78678, 423);
      
      String actual = viewProvider.provideDivisionView(steps, 78678, 423);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsFour() {
      String expected = "_78945 |4234" + BREAK + 
                        " 4234  |--"   + BREAK + 
                        " ----  |18"   + BREAK + 
                        "_36605"       + BREAK + 
                        " 33872"       + BREAK + 
                        " -----"       + BREAK + 
                        "  2733";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 4234);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 4234);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendMoreDividerAndDividerLengthIsFive() {
      String expected = "_78945 |42345" + BREAK + 
                        " 42345 |-"     + BREAK + 
                        " ----- |1"     + BREAK + 
                        " 36600";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 42345);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 42345);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void calculateShouldReturnColumnSolvedEquationIfDividendEqualsDivider() {
      String expected = "_78945 |78945" + BREAK + 
                        " 78945 |-"     + BREAK + 
                        " ----- |1"     + BREAK + 
                        "     0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(78945, 78945);
      
      String actual = viewProvider.provideDivisionView(steps, 78945, 78945);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendHasZero() {
      String expected = "_100000 |25"   + BREAK + 
                        " 100    |----" + BREAK + 
                        " ---    |4000" + BREAK + 
                        "   _0"         + BREAK + 
                        "    0"         + BREAK + 
                        "    -"         + BREAK + 
                        "    _0"        + BREAK +
                        "     0"        + BREAK +
                        "     -"        + BREAK +
                        "     _0"       + BREAK +
                        "      0"       + BREAK +
                        "      -"       + BREAK +
                        "      0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(100000, 25);
      
      String actual = viewProvider.provideDivisionView(steps, 100000, 25);
      
      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividerMoreDividend() {
      String expected = "_21 |55" + BREAK + 
                        "  0 |-"  + BREAK + 
                        "  - |0"  + BREAK +
                        " 21";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(21, 55);
      
      String actual = viewProvider.provideDivisionView(steps, 21, 55);

      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfDividendIsZero() {
      String expected = "_0 |55" + BREAK + 
                        " 0 |-"  + BREAK + 
                        " - |0"  + BREAK +
                        " 0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(0, 55);
      
      String actual = viewProvider.provideDivisionView(steps, 0, 55);

      assertEquals(expected, actual);
   }
   
   @Test
   void provideDivisionViewShouldReturnColumnSolvedEquationIfQuotientHasZero() {
      String expected = "_5446560 |7"      + BREAK + 
                        " 49      |------" + BREAK + 
                        " --      |778080" + BREAK + 
                        " _54"             + BREAK + 
                        "  49"             + BREAK + 
                        "  --"             + BREAK + 
                        "  _56"            + BREAK + 
                        "   56"            + BREAK + 
                        "   --"            + BREAK + 
                        "    _56"          + BREAK + 
                        "     56"          + BREAK + 
                        "     --"          + BREAK + 
                        "      _0"         + BREAK + 
                        "       0"         + BREAK + 
                        "       -"         + BREAK + 
                        "       0";
      
      List<DivisionStep> steps = new DivisionMathProviderImpl().provideMathCalculation(5446560, 7);
      
      String actual = viewProvider.provideDivisionView(steps, 5446560, 7);
      
      assertEquals(expected, actual);
   }
}
