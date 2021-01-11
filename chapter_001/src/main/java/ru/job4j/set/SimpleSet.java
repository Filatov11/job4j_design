package ru.job4j.set;
import  ru.job4j.list.SimpleArray;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

 private  SimpleArray <E> arrForSet = new SimpleArray<E>();
    public boolean checkElement(E elem) {
       boolean res = false;
        for ( E part :
             arrForSet) {
           if (part.equals(elem)) { res = false;}
           else  {res = true; break; }
        }
        return res;
    }

    void add(E e) {
    if (checkElement(e)) {
        arrForSet.add(e);
    }

    }

    @Override
    public Iterator<E> iterator() {
     return  arrForSet.iterator();
    }
}
