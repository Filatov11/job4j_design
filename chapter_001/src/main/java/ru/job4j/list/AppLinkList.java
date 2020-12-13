package ru.job4j.list;

public class AppLinkList {
    public static void main(String[] args) {
        CustLinkedList<Person> app = new CustLinkedList<Person>();
        app.add(new Person("Fred", "Person one"));
        app.add(new Person("Mark", "Person two"));
        app.add(new Person("Teddy", "Person three"));
        app.add(new Person("Sam", "Person four"));
        System.out.println("0000" );


       while (app.iterator().hasNext()) {
     System.out.println("111" );
         System.out.println(app.iterator().next().name  );
      }
    }
}