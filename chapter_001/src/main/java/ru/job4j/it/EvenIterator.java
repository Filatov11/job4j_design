package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private int currentPosition = 0;
    private int[] array;

    public boolean checkOdd(int val) {

        if (val % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    EvenIterator(int[] arr) {
        array = arr;
    }

    @Override
    public boolean hasNext() {
        while ((array.length - 1) > currentPosition) {
            if (!checkOdd((array[currentPosition]))) {
                currentPosition++;
            } else {
                break;
            }
        }

        return ((checkOdd((array[currentPosition]))) && ((array.length) > currentPosition));
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return (array[currentPosition++]);
    }
}
