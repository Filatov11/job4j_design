package ru.job4j.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T temp = null;
        temp = linked.deleteLast();
        return temp;


    }

    public void push(T value) {
    linked.add(value);
    }
}