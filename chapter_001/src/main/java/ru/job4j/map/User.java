package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    private String name;
    private  int children;
    private  Calendar birthday;
    public User (String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


    public int hashCode(){
        System.out.println("Calling hashCode()");
       int  hash = name.hashCode() + children + birthday.hashCode();
        System.out.println("hashCode value is " + hash);
        return hash;
    }


}
