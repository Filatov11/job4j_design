package ru.meta.chap1;
import  ru.meta.chap1.WriteAction;
public class SProg {
    public static void main (String[] args) {
        WriteAction wra = new WriteAction("Some String");
        wra.printString();
    }
}
