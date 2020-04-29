package ua.com.foxminded.calculator.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class ConsoleReaderImplTest {
   ConsoleReader reader = new ConsoleReaderImpl();

   final InputStream systemIn = System.in;

   @Test
   void readShouldThrowUnsupportedOperationException() {
      Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
         reader.read();
      });

      assertEquals("Not supported yet.", exception.getMessage());
   }

   private void provideInput(String data) {
      ByteArrayInputStream testIn;

      testIn = new ByteArrayInputStream(data.getBytes());

      System.setIn(testIn);
   }

   @Test
   void readIntValueShouldReturnThree() {
      Integer expected = 3;

      provideInput(expected.toString());

      int actual = reader.readIntValue();

      assertEquals(expected, actual);

      System.setIn(systemIn);
   }
   
   @Test
   void readIntValueShouldThrowIllegalArgumentException() {
      provideInput("asd");
      
      assertThrows(IllegalArgumentException.class, () -> {
         reader.readIntValue();
      });
      
      System.setIn(systemIn);
   }
}
