package ru.job4j.map;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class UserMap {
    Object obj;
    User user;
    public  static void main (String[] args) {
        Map<User,Object>  usrMap = new HashMap<User, Object>();
        usrMap.put(new User("Nik", 2, new GregorianCalendar(1976, 10 , 02)), new Object());
        usrMap.put(new User("Tom", 3, new GregorianCalendar(1976, 05 , 10)), new Object());

        for (Map.Entry<User,Object>  item :    usrMap.entrySet())

        System.out.println( item.getKey().getBirthday().toString() + " " +  item.getKey().getChildren()  + " "
                 + item.getKey().getName() + " val " + item.getValue().toString() );


    }






}
