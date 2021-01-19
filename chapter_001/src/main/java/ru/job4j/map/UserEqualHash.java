package ru.job4j.map;
import java.util.Calendar;
public class UserEqualHash {
    private String name;
    private int children;
    private Calendar birthday;

    public UserEqualHash(String name, int children, Calendar birthday) {
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
        if (!(obj instanceof UserEqualHash))  return  false;
        if ( obj == this) return true;
        return  this.getName() ==  ((UserEqualHash) obj).getName() &&
                this.getChildren() == ((UserEqualHash) obj).getChildren() &&
                this.getBirthday() == ((UserEqualHash) obj).getBirthday();
    }


    public int hashCode(){
        System.out.println("Calling hashCode()");
        int  hash = name.hashCode() + children + birthday.hashCode();
        System.out.println("hashCode value is " + hash);
        return hash;
    }

}
