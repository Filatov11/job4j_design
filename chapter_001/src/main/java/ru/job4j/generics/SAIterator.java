package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SAIterator<T> implements Iterator<T> {
    private T array[];
    private int current = 0;
    private int count ;
    public SAIterator(T arr[], int  cntval ) {
        array = arr;
        count = cntval;
    }
    public boolean hasNext() {
        return current < count;
    }
    public T next() throws NoSuchElementException {
        if (hasNext()) {
            current++;
            return array[current - 1];
        }
        else
            throw new NoSuchElementException();
    }
    }



