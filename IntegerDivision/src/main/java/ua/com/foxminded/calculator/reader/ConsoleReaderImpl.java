package ua.com.foxminded.calculator.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderImpl implements ConsoleReader {
   @Override
   public String read() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public int readIntValue() {
      try {
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) {
            @Override
            public void close() {
            }
         })) {
            return Integer.parseInt(reader.readLine());
         }
      } catch (NumberFormatException | IOException ex) {
         throw new IllegalArgumentException(ex);
      }
   }
}
