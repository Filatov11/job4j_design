package ru.job4j.generics;
import ru.job4j.generics.Person;

import java.util.*;

public class GenericUsage {

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }



    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(l);

        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
       // list.add(new Person("name", 21, new Date(913716000000L)));
        System.out.println("Количество элементов в списке: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            System.out.println("Текущий элемент: " + s);
        }



    }


        public void printInfo(Collection<? extends Person> col) {
            for (Iterator<? extends Person> it = col.iterator(); it.hasNext(); ) {
                Person next = it.next();
                System.out.println(next);
            }
        }


}
