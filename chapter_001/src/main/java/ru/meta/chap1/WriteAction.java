package ru.meta.chap1;

public class WriteAction {
   private String somString;
    public WriteAction(String somString) {
        this.somString = somString;
    }
    public void printString() {
        System.out.println("write "+ somString);
    }
}
