package ru.job4j.list;

import java.util.*;


public class SimpleArray<T> implements Iterable<T> {
    private static final int initSize = 10;
    private int currSize;
    private T[] smpArray;
    protected transient int modCount = 0;
    int expectedModCount = modCount;
    private int position = 0;

    public SimpleArray() {
        smpArray = (T[]) new Object[10];
    }

    public T get(int index) {

        Objects.checkIndex(index, position);

        return smpArray[index];

    }

    public void add(T obj) {

        if (currSize == smpArray.length) {
            increaseListSize();
        }
        smpArray[this.position++] = obj;
        modCount++;
    }


    public int getSizeOfArray() {
        return this.currSize;
    }


    private void increaseListSize() {
        smpArray = Arrays.copyOf(smpArray, smpArray.length * 2);
        this.currSize = smpArray.length;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) smpArray[index++];
            }
        };
    }
}