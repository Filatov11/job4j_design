package ru.job4j.contcollect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Analize {

    public static void main(String[] args) {
        List < User > current = Arrays.asList( new User[] {
                new User(1, "qweer"),
                new User(3,"wert"),
                new User(4,"wert"),
                new User(5,"wert"),
                new User(6,"wert")
        });
        List < User > previous = Arrays.asList(new User[] {
                new User(1,"wert"),
                new User(2,"wert"),
                new User(3,"wert"),
                new User(4,"wert")
        });





    }


    public static Info diff(List<User> previous, List<User> current) {
      boolean add = true; boolean ch = true; boolean dl = true;
        Info info = new Info();
        HashMap<Integer, User> seen = new HashMap<>();
        for(int i = 0; i < current.size(); i++) {
            seen.put(current.get(i).id, current.get(i));
        }

        for (User user: previous) {
            if (!seen.containsKey(user.id)) { info.incrDeleted(); }
            if (seen.containsKey(user.id) && !user.name.equals(seen.get(user.id).name)) {info.incrChanged();}
            }
          info.setAdded( current.size() - previous.size() + info.getDeleted());
     //   }

        ArrayList<User> intersections = new ArrayList<>();




return  info;
    }









    public static class User {


        int id;
        String name;


       public User(int id, String Str) {
           this.id = id;
           this.name = Str;
       }
        public  int getId (User user) {
            return user.id;
        }
    }

    public static class Info {

        int added = 0;
        int changed = 0;
        int deleted = 0;

        public Info () {
            added = 0;
            changed = 0;
            deleted = 0;



        }

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }



        public  void incrChanged() {
         this.changed++;
        }
        public  void incrDeleted() {
          this.deleted++;
        }
        public  void incAdded( List<User> prew , List<User> curr) {
            this.added++;
        }






    }




    public  int getId (User user) {
        return user.id;
    }

}
