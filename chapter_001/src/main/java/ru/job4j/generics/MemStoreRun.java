package ru.job4j.generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.job4j.generics.MemStore;

public class MemStoreRun  {

    public static void main(String[] args) {

        UserStore gArray = new UserStore() ;
        Store<? super Base> n1 = new MemStore<Base>();

        gArray.add(new User("Tom"));
        gArray.add(new User("Willy"));
        gArray.add(new User("Jack"));

        n1.add(new User("Tom"));
        n1.add(new Role("turner"));
        n1.add(new User("Smith"));
       n1.lstArray();
       System.out.println("_---------");
       n1.replace("Tom",new User("Rocky"));
       n1.delete("Smith");
        n1.lstArray();


    }




}
