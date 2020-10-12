package ru.job4j.it;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.stream.IntStream.range;


public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }
    @Override
    public boolean hasNext() {
        if (row >= data.length)
            return false;
        if (column >= data[row].length &&
                (row >= data.length || row == data.length - 1))
            return false;
        return true;
    }
    @Override
    public Integer next() {
          int val=0;
        if (!hasNext())
            throw new NoSuchElementException();
    //    if ((column >= data[row].length) && (data[row].length > 0))  {
       //     row++;
            //column = 0;
        // column++;
        //
        System.out.println("Begin Column = " + column + " , Begin Row = " + row);
        System.out.println("Be data[row].length) = " + data[row].length + " , DL = " +  data.length);
      //  while ((data[row][column] == 0) && (row < data.length-1) ) {
       while ((data[row][column] == 0) && (row < data[row].length-1) ) {
           row=0;
                while ((data[row][column] == 0) && (column < data.length-1) ) {
                    System.out.println("Column = " + column + " ,  Row = " + row);
                    System.out.println("Value = " + val );
                    val = data[row][column];
                    row++;
                }
                column++;
            }

    //     ret =    data[row][column];
     //  } ;
    return  val;
    }
}