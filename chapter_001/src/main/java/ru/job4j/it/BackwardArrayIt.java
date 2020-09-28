package ru.job4j.it;


import java.util.Arrays;
        import java.util.Iterator;
        import java.util.*;
        import java.util.NoSuchElementException;
        import java.util.stream.*;
        import java.util.List;


public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;



    public BackwardArrayIt(int[] data) {
        this.data = data;
    }


    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        // int l = data.length-1;
        //  int   i = data.length- this.next();
        if (!hasNext()) {
            throw new  NoSuchElementException();
        }
        this.point++;
        //    Collections.reverse(Arrays.asList(this.data));
        //      System.out.println("next =" + this.point );
        return  this.data[this.data.length - this.point];
    }
}
