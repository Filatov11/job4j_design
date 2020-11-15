package ru.job4j.generics;

import java.util.Arrays;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T>  implements Iterable<T>

{
    private T[] uniArr;
    //int current = 0;
   private int count = 0 ;
    private int capacity;
    public  SimpleArray(T[] arr) {
        uniArr = arr;
    }

    public  SimpleArray(int capacity) {
        this.uniArr = (T[]) new Object[capacity];
    }





    public void   add(T model) {
        int index;
        index = count;
     //   System.out.println("index = "+ index );
      //  index = Objects.checkIndex(index, count);
    //     System.out.println("index = "+ index );
            uniArr[count++] = model;

    }

    public  void  set(int index, T model) {
        Objects.checkIndex(index, count);
            this.uniArr[index] = model;

      }

    public void remove(int index)  {
       index =  Objects.checkIndex(index, count);

            System.arraycopy(uniArr, index + 1, uniArr, index, uniArr.length - 1 - index);
            uniArr[uniArr.length - 1] = null;
            count--;

    }


  //  public boolean checkIndex(int index) {
   //        boolean cInd;
   //     if  (this.uniArr.length > index)
   //     {cInd = true;}  else
   //     {cInd = false;}
   //     return  cInd;
   // }

    public T get(int index) {
        T retVal = null;
        index =  Objects.checkIndex(index, count);

            retVal = this.uniArr[index];

        return retVal;
        }


    public static void main(String[] args) {

        SimpleArray<String> array1 = new SimpleArray(5);

        array1.add("Hello"); array1.add("world");

        array1.add("my");


        array1.remove(2);

        array1.set(1, "land");

         for ( String s : array1.uniArr) {
       //    System.out.println(s);
         }

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}






