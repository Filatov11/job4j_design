package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        Node nextNode = head;  // head of original list will be last node
        Node prevNode = null; // init nextdoor node
        Node currNode = null; // init current node

        while (nextNode != null) {   // until all nodes will be taken
            currNode = nextNode;  //  current node will be next node
            nextNode = nextNode.next; // renew pointer to next node

            currNode.next = prevNode;  // link  prev node  to current node
            prevNode = currNode; //     set link prev to current
            head = currNode;  // head of list will be current node


        }

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