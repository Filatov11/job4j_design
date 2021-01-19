package ru.job4j.map;

import java.util.Calendar;

public class UserEqual {
    private String name;
    private int children;
    private Calendar birthday;

    public UserEqual(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

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


    public boolean equals(Object obj) {
        System.out.println("Calling equals() for User: " + obj);
        if (obj == null) return false;
        if (!(obj instanceof UserEqual))  return  false;
        if ( obj == this) return true;
        return  this.getName() ==  ((UserEqual) obj).getName() &&
                this.getChildren() == ((UserEqual) obj).getChildren() &&
                this.getBirthday() == ((UserEqual) obj).getBirthday();


    }


}
