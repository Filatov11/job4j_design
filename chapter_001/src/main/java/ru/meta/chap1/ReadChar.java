package ru.meta.chap1;

public class ReadChar {
    public static void main (String[] args) {
      int x;
      try {
          x=System.in.read();
          char c = (char)x;
          System.out.println("Read from console: " + x);
      } catch (java.io.IOException e) {
          System.err.println("Exception: " + e);
      }

    }
}
