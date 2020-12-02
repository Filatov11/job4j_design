package ru.job4j.list;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;


public class SimpleArray <T> implements Iterable<T> {
    private static final int initSize = 10;
    private int CurrSize;
    private T[] smpArray;
    private int CurrNumber;

    public SimpleArray() {
        smpArray =  (T[])new Object[10];
    }

    public T get(int index){
        if(Objects.checkIndex(index,smpArray.length) < getSizeOfArray()){
            return smpArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(T obj){
        if(smpArray.length-getSizeOfArray() <= 5){
            increaseListSize();
        }
        smpArray[this.CurrSize++] = obj;
    }

    @Override
    public Iterator<T> iterator() {
        int modCount = 0;
        int expectedModCount = modCount;

        if (expectedModCount != modCount) {
            Iterator<T> iterator = Arrays.stream(smpArray).iterator();
            return iterator;
        }   else {
            throw new ConcurrentModificationException();
        }

    }

   public int getSizeOfArray() {
        return  this.CurrSize;
   }



    private void increaseListSize(){
        smpArray = Arrays.copyOf(smpArray, smpArray.length*2);
        System.out.println("\nNew length: "+smpArray.length);
    }
}
