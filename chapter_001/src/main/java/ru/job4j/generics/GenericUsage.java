package ru.job4j.generics;
import java.util.ArrayList;
import java.util.List;
public class GenericUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        for (String s : list) {
            System.out.println("Current element is: " + s);
        }
    }
}
