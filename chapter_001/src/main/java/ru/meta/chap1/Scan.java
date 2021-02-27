package ru.meta.chap1;
import java.util.Scanner;
public class Scan {
    public static void main(String[] args) {
        System.out.println("Read from console: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("name: "+ name);
        scan.close();

    }

}
