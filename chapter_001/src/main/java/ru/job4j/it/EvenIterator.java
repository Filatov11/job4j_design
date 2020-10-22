package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private int currentPosition = 0;
    private int[] array;

    public boolean checkOdd(int val) {
        return val % 2 == 0;
    }

    EvenIterator(int[] arr) {
        array = arr;
    }

    @Override
    public boolean hasNext() {
        while (((array.length - 1) > currentPosition) && (!checkOdd((array[currentPosition])))) {
            currentPosition++;
        }
        return (((array.length) > currentPosition) && (checkOdd((array[currentPosition]))));
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return (array[currentPosition++]);
    }
}
