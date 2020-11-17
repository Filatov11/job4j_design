package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SAIterator<T> implements Iterator<T> {
    private T array[];
    private int current = 0;
    public SAIterator(T anArray[]) {
        array = anArray;
    }
    public boolean hasNext() {
        return current < array.length;
    }
    public T next() throws NoSuchElementException {
        if (hasNext())
            return array[current++];
        else
            throw new NoSuchElementException();
    }
    }



