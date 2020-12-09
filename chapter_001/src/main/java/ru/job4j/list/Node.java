package ru.job4j.list;


public class Node<E> {
    public void setKey(int key) {

        this.key = key;
    }
    private E value;

    public int getKey() {
        return key;
    }

    private int key;
    private Node<E> next;


    public E getValue() {
        return value;
    }
    public Node<E> getNext() {
        return next;
    }


    public void setValue(E value) {
        this.value = value;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }


}