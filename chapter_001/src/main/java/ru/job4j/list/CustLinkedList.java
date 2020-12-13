package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustLinkedList<E> implements Iterable<E> {
    public static int size = 0;
    private Node<E> node;
    private int modCount = 0;


    public CustLinkedList() {
        size = 0;
        node = null;
    }


    public void add(E value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (node == null) {
            node = newNode;
        } else {
            Node temp = node;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp = newNode;
        }
        size++;
        modCount++;
        return;

    }
    public E get(int index) {
        Objects.checkIndex(index, size);
        int position = 0;
        Node current = node;
        while (position != index) {
            current = current.getNext();
            position++;
        }
        return (E) current.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = node;
            private int index;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                 if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = (E) current.getValue();
                current = current.getNext();
                index++;
                return data;
            }
        };
    }
}


    /*




*/