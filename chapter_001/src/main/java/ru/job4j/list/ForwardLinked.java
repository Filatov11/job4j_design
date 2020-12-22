package ru.job4j.list;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
   // private Node<T> ending;
    int size =0;

    public T deleteFirst() {
        if(head==null){  //means LinkedList in empty, throw exception.
            throw new NoSuchElementException();
        }
        Node tempNode = head; // save reference to first Node in tempNode- so that we could return saved reference.
        head = head.next; // delete first Node (make first point to second node)
        //  return tempNode;
        return (T)tempNode.value;
    }

    public T deleteLast() {
        T val = null;
        if(head == null) {
            throw new NoSuchElementException();
        }
        else {
            if (size == 1)  {
                Node temp = head;
                head = null;
                size--;
                return (T)temp.value;
            }
            Node point = head;
            while(point.next != null) {
                point = point.next;
            }
            val = (T)point.value;
            point.next = null;
            size--;
            return val;
        }


    //    return val;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}