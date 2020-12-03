package ru.job4j.list;
import java.util.Iterator;
import java.util.*;


public class SimpleArray <T> implements Iterable<T> {
    private static final int initSize = 10;
    private int currSize;
    private T[] smpArray;
    private int currNumber;
    protected transient int modCount = 0;


    public SimpleArray() {
        smpArray = (T[]) new Object[10];
    }

    public T get(int index) {

        Objects.checkIndex(index, currSize);

        return smpArray[index];

    }

    public void add(T obj) {

        if (currSize == smpArray.length) {
            increaseListSize();
        }
        smpArray[this.currSize++] = obj;
        modCount++;
    }


    public int getSizeOfArray() {
        return this.currSize;
    }


    private void increaseListSize() {
        smpArray = Arrays.copyOf(smpArray, smpArray.length * 2);
        System.out.println("\nNew length: " + smpArray.length);
    }

    public boolean arrIsEmpty() {
        boolean empty = true;
        for (int i = 0; i < smpArray.length; i++) {
            if (smpArray[i] != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }


    @Override
    public Iterator<T> iterator() {
        if (arrIsEmpty()) throw new NoSuchElementException();
        Iterator<T> iterator = new SimpleArrayIterator();
        try {
            System.out.println("Iterator created");
            return iterator;
        } catch (NoSuchElementException exception) {
        }
        ;
        return null;
    }

    private class SimpleArrayIterator implements Iterator {
        private int position = 0;

        public boolean hasNext() {
            if (position < smpArray.length)
                return true;
            else
                return false;
        }

        public T next() {

            if (this.hasNext()) {
                checkForComodification();
                return smpArray[position++];
            } else


                return null;
        }



        final void checkForComodification() {
          //  if (modCount != expectedModCount)
         //       throw new ConcurrentModificationException();
        }





        @Override
        public void remove() {

        }


    }


}
