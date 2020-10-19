package ru.job4j.it;
import java.util.*;
import java.util.Arrays;

import java.util.stream.Collectors;

public class EvenIterator implements Iterator<Integer> {
    private int currentPosition = 0;
    private int [] array;
    //public EvenIterator(int arr
  //  public int get(int index) { return array[index]; }
    Iterator<Integer> enIter;
    // List<Integer> intList = new List<Integer>;;
    List<Integer> intList;
   //  ArrayList<Integer> intList = new ArrayList<>();

    public boolean checkOdd (int val) {

        if (val % 2 == 0)  {return  true;}
        else {return  false;}
    }
      EvenIterator(int[] arr) {
array = Arrays.copyOf(arr, arr.length);
    }
    @Override
    public boolean hasNext() {
       /// boolean res = false;
    while (( !checkOdd(Integer.valueOf(array[currentPosition]))) &&  ((array.length-1) > currentPosition))
    { currentPosition++; }

        return (( checkOdd(Integer.valueOf(array[currentPosition]))) &&  ((array.length) > currentPosition)) ;
    }

    @Override
    public Integer next() {
        Integer itg =0;
        if (!hasNext())
            throw new NoSuchElementException();
        return Integer.valueOf(array[currentPosition++]);
       // currentPosition++;
     //   return intList.get(this.currentPosition);
    }
}
