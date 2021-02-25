package ru.job4j.contcollect;

import java.util.HashMap;
import java.util.List;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        HashMap<Integer, User> seen = new HashMap<>();
        for (int i = 0; i < current.size(); i++) {
            seen.put(current.get(i).id, current.get(i));
        }
        for (User user : previous) {
            if (!seen.containsKey(user.id)) {
                info.incrDeleted();
            }
            if (seen.containsKey(user.id) && !user.name.equals(seen.get(user.id).name)) {
                info.incrChanged();
            }
        }
        info.setAdded(current.size() - previous.size() + info.getDeleted());
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String Str) {
            this.id = id;
            this.name = Str;
        }

        public int getId(User user) {
            return user.id;
        }
    }

    public static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        public Info() {
            this.added = 0;
            this.changed = 0;
            this.deleted = 0;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getDeleted() {
            return deleted;
        }

        public void incrChanged() {
            this.changed++;
        }

        public void incrDeleted() {
            this.deleted++;
        }

    }

    public int getId(User user) {
        return user.id;
    }

}
