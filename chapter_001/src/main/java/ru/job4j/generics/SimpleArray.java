package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<Object> {
    public class SAIterator<T> implements Iterator<T> {
        int current = 0;
        T[] val;

        public boolean hasNext() {
            if (current < val.length - 1) {
                return true;
            } else {
                System.out.println("current = " + current + " false ");
                return false;
            }
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return val[current++];
        }

        public Iterator<T> iterator() {
            //Iterator<T> it = this.iterator();
            //this.val = itarr;
            /// return new SAIterator().iterator();
            return iterator();
        }

    }

    private T[] uniArr;
    private int count = 0;
    private int capacity;

    public SimpleArray(T[] arr) {
        uniArr = arr;
    }

    public SimpleArray(int capacity) {
        this.uniArr = (T[]) new Object[capacity];
    }

    public void add(T model) {
        int index;
        index = count;
        uniArr[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        this.uniArr[index] = model;
    }

    public void remove(int index) {
        index = Objects.checkIndex(index, count);
        System.arraycopy(uniArr, index + 1, uniArr, index, uniArr.length - 1 - index);
        uniArr[uniArr.length - 1] = null;
        count--;
    }

    public T get(int index) {
        T retVal = null;
        index = Objects.checkIndex(index, count);
        retVal = this.uniArr[index];

        return retVal;
    }


    @Override
    public Iterator<Object> iterator(T[] Arr) {
        return new SAIterator();
    }


    public static void main(String[] args) {


        SimpleArray<String> array1 = new SimpleArray<String>(5);
        array1.add("Hello");
        array1.add("world");
        array1.add("my");
        array1.remove(2);
        array1.set(1, "land");

        for (String s : array1.uniArr) {
            System.out.println(s);
        }


    }


}






