package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")));
            int data;
            while ((data = br.read()) > 0)  {
                builder.append((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public  void writeDataInFile(String path, String data) {
  try {
      BufferedWriter br = new BufferedWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"),true));
      br.write(data + System.lineSeparator());
  } catch (IOException e) {
      e.printStackTrace();
  }
    }

    public static void main(String[] args) {
        String path = "./src/data/text.txt";
        UsageEncoding encoding = new UsageEncoding();
        String s = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
