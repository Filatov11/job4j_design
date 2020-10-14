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
        while (row < data.length && data[row].length == column) {
            column = 0;
            row++;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();

            return data[row][column++];
}
}