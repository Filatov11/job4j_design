package ru.job4j.generics;
public class UserStore<User extends Base> implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
      store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        if (store.findById(id) == null)  {
            return false;
        }
        store.replace(id,model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (store.findById(id) == null)  {
            return false;
        }
        store.delete(id);
        return false;
    }

    @Override
    public User findById(String id) {
        store.findById(id);
        return null;
    }
}