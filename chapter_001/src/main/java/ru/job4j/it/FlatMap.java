package ru.job4j.it;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor;
    private int currentPosition = 0;

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    private void check(){
        if (cursor == null && data.hasNext())
            cursor = data.next();
    }

    @Override
    public boolean hasNext() {
        check();
        if(cursor == null)
            return false;
        if(cursor.hasNext())
            return true;

        if(data.hasNext())
            cursor = data.next();

        return cursor.hasNext();
    }

    @Override
    public T next() {
        check();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if(!cursor.hasNext() && data.hasNext())
            cursor = data.next();

     //   return currentIterator.next();
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}