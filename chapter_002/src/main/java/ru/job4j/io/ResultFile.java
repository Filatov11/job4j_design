package ru.job4j.io;

import java.io.File;
import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try
                (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, world!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File("result.txt");
            FileOutputStream fos = new FileOutputStream(file, true);
            fos = new FileOutputStream(file, true);
            fos.write(("\n ====================  //////////////  ============= ").getBytes());
            fos.write(("\n ").getBytes());
            int x = 9;
            fos.write("   ".getBytes());
            for (int k = 0; k <= x; k++) {
                fos.write((String.format("%3d", k) + "  ").getBytes());
            }
            fos.write(("\n +------------------------------------------------- \n ").getBytes());
            for (int i = 0; i <= x; i++) {
                fos.write((i + "| ").getBytes());
                for (int j = 0; j <= x; j++) {
                    fos.write((String.format("%3d", j * i) + "  ").getBytes());
                }
                fos.write(("\n ").getBytes());
            }
            fos.write(("\n").getBytes());
            fos.write(("\n\n").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
