package ru.job4j.list;
import  ru.job4j.list.Node;

import java.lang.management.MemoryNotificationInfo;
import java.util.Objects;
import java.util.Iterator;

public class CustLinkedList<E> implements Iterable<E> {
    public static int size;
    private Node first;
    private Node last;


    public CustLinkedList() {
        first = last = null;
        size=0;
    }


    public   void add(E value) {
        Node new_node = new Node();
        new_node.setValue(value);
        if (first == null) {
            first = new Node();
            first.setValue(value);
            return;
        }
        new_node.setNext(null);
        Node last = first;
        while (last.getNext() != null)
            last = last.getNext();
        last.setNext(new_node);
        size++;
        return;

    }

    public  E get(int index) {
        int ind = Objects.checkIndex(index,size);
         Node temp = first;
         while (temp != null) {
             if (temp.getKey() == ind) {
                 return (E)temp;
             }
             temp = temp.getNext();
         }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private Node current;

            @Override
            public boolean hasNext() {
                return  current != null;
            }

            @Override
            public E next() {
                Node temp = current;
                current = current.getNext();
                return (E) temp;
            }
        };
    }
}

