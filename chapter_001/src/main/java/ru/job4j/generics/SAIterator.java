package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SAIterator<T> implements Iterable<T> {
    int current = 0;
    T[] val;
    @Override
    public Iterator iterator() {
        return null;
    }

    public boolean hasNext() {
        if (current < SAIterator.this.val.length) {
            return true;
        } else {
            return false;
        }
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return val[current++];
    }



}


