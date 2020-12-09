package ru.job4j.list;

public class AppLinkList {
    public static void main (String [] args) {
        CustLinkedList app = new CustLinkedList();
        app.add(new Person("Fred","Person one"));
        app.add(new Person("Mark","Person two"));
        app.add(new Person("Teddy","Person three"));
        app.add(new Person("Sam","Person four"));

        System.out.println(app.get(0));
    }
}
