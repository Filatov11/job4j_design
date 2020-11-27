package ru.job4j.generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.job4j.generics.MemStore;

public class MemStoreRun {

    public static void main(String[] args) {

        // Массив String.
        String[] names = new String[] { "Tom", "Jerry" };
        List<String> li = new ArrayList<String>();
        List<String>  li1 = Arrays.asList(new String[]{"foo", "bar"});

        MemStore<? super Base> gArray = new MemStore<Base>() ;
        Store<? extends Base> n1 = new MemStore<Base>();

        gArray.add(n1);


        MemStore<String> object = new MemStore<>();


       // String last = gArray.getLastElement();


    }

}
