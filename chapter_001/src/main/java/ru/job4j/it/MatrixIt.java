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
        boolean res;






        if  ((row < this.data.length) || (this.column < this.data[row].length)) {

            res = true;
        } else {
            res = false;
        }
        return res;
        // return row < data.length[] && ;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();

        }

        final IntStream intStream = range(0, this.data.length).
                flatMap(rowArr -> range(0, this.data[row].length).map(col -> {
            final int element = this.data[rowArr][col];
              this.column = col;
              this.row = rowArr;
            // E.g. multiply elements in odd numbered rows and columns by two.
            return element;

        }));

        intStream.forEachOrdered(n -> System.out.print(n + " "));
      return 0;

    }
}
