package ru.job4j.generics;

import java.util.Arrays;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T>  implements Iterable<T>
{
    T[] uniArr;
    int current = 0;
    int count = 5;
    public  SimpleArray(T[] arr) {
        uniArr = arr;
    }

    public int  firstEmpty() {
        int i = current;
        while ( (this.uniArr[current] != null) &&  (current < this.uniArr.length-1) ) {
            i = current++;
        }
        return i;

    }

    public void   add(T model) {
        int index;
        index = firstEmpty();
        index = Objects.checkIndex(index, count-1);

            uniArr[current++] = model;

    }

    public  void  set(int index, T model) {
        Objects.checkIndex(index, count-1);
      if (checkIndex(index)) {
            this.uniArr[index] = model;
        }
      }

    public void remove(int index)  {
       index =  Objects.checkIndex(index, count-1);
        if (checkIndex(index)) {
            System.arraycopy(uniArr, index + 1, uniArr, index, uniArr.length - 1 - index);
            uniArr[uniArr.length - 1] = null;
            count--;
        }
    }


    public boolean checkIndex(int index) {
           boolean cInd;
        if  (this.uniArr.length > index)
        {cInd = true;}  else
        {cInd = false;}
        return  cInd;

    }
    public T get(int index) {
        T retVal = null;
        if (checkIndex(index)) {
            retVal = this.uniArr[index];
        }
        return retVal;
        }


    public static void main(String[] args) {

        String[] strings = new String[]{"Hello", "World"};



        SimpleArray<String> array1 = new SimpleArray<>(strings);
        //System.out.println(array1.get(0));
        array1.add("my");


        array1.remove(2);

        array1.set(1, "land");
         for ( String s : array1.uniArr ) {
           System.out.println((String)s);
         }

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}






