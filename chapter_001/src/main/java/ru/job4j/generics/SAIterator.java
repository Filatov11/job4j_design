package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SAIterator<T> implements Iterator<T> {
    int current = 0;
    T[] val;



    public boolean hasNext() {
        System.out.println(" hasnext " + " current = " + current );
        System.out.println(" SAIterator.this.val.length " + val.length );
        if (current < val.length-1) {
            System.out.println("current = " + current + " true ");
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

   // @Override
    public Iterator<T> iterator() {
        //Iterator<T> it = this.iterator();
     //this.val = itarr;
     return new SAIterator().iterator();
    }


}


