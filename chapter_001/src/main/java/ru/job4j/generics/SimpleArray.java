package ru.job4j.generics;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new SAIterator<T> (uniArr, count);
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
        System.arraycopy(uniArr, index , uniArr, index -1, uniArr.length  - index);
        uniArr[count] = null;
        count--;
    }
    public T get(int index) {
        T retVal = null;
        index = Objects.checkIndex(index, count);
        retVal = this.uniArr[index];

        return retVal;
    }

    public static void main(String[] args) {

        SimpleArray<String> array1 = new SimpleArray<String>(5);

        array1.add("Hello");
        array1.add("world");
        array1.add("my");
        array1.remove(2);
        array1.set(1, "land");
        array1.add("my1");
        Iterator<String> iterator = new SAIterator(array1.uniArr, array1.count);

       while(iterator.hasNext()) {
           System.out.println((String) iterator.next());
       }

    }


}


