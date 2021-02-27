package ru.meta.chap1;

public class PrintArguments {
    public static void main (String [] args) {
        System.out.printf("----");
        for (String st: args) {

            System.out.printf("Aргумент-> %s%n", st);
        }
    }
}
