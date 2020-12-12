package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CustLinkedList<E> implements Iterable<E> {
    public static int size = 0;
    private Node<E> node;
    private Node<E> currPoint;


    public CustLinkedList() {
        size = 0;
        currPoint = this.node;
    }


    public void add(E value) {
        ConcurrentModification();
        Node newNode = new Node();
        newNode.setValue(value);
        if (newNode == null) {
            return;
        }
        if (node == null) {
            node = new Node<E>();
            node.setValue(value);
        } else {
            Node<E> nNode = new Node<E>();
            nNode.setValue(value);
            Node<E> lastNode = getLast(node);
            lastNode.setNext(newNode);
        }
        resetIteratorPoint();
        size++;
        return;

    }


    private void resetIteratorPoint() {
        currPoint = this.node;
    }

    private Node<E> getLast(Node<E> node) {

        Node<E> lastNode = node;
        if (lastNode.getNext() != null) {
            return getLast(lastNode.getNext());
        } else {
            return lastNode;
        }
    }

    public void ConcurrentModification() throws ConcurrentModificationException {
        if (currPoint != this.node) {
            throw new ConcurrentModificationException("Concurrent modification");
        }
    }

    public E get(int index) {
        return getNode(index).getValue();
    }

    public Node<E> getNode(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index not available.");
        }
        // If index=0 , return head
        if (index == 0) {
            return this.node;
        }
        // If index= size, return last node
        if (index == this.size - 1) {
            return getLast(this.node);
        }
        int pointer = 0;
        Node<E> pointerNode = this.node;
        while (pointer <= index) {
            if (pointer == index) {
                return pointerNode;
            } else {
                pointerNode = next(pointerNode);
                pointer++;
            }
        }
        return null;
    }

    private Node<E> next(Node<E> node) {
        if (node.getNext() != null) {
            return node.getNext();
        } else {
            return null;
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            //   private Node current;

            @Override
            public boolean hasNext() {
                {
                    if (currPoint == null) {
                        resetIteratorPoint();
                        return false;
                    } else {
                        return true;
                    }
                }
            }

            @Override
            public E next() {
                E data = (E) currPoint.getValue();
                currPoint = currPoint.getNext();
                return data;

            }
        };
    }
}


    /*




*/