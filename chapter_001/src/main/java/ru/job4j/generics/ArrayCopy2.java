package ru.job4j.generics;

import java.util.Arrays;

public class ArrayCopy2 {
    public static void main(String[] args) {
        int index;
        int[] array = {1, 2, 3, 4, 5, 6, 7, };
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
        index = 2;
        System.arraycopy(array, index+1, array, index , array.length-1-index);

          array[array.length-1] = 0 ; //Integer.parseInt(null);

        index = 3;
        System.arraycopy(array, index+1, array, index , array.length-1-index);
        array[array.length-1] = 0 ;
        System.out.println(array.length);
        System.out.println(Arrays.toString(array));
    }
}