package ru.job4j.generics;
import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
     mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
       add(model);
       return  delete(id);

    }

    @Override
    public boolean delete(String id) {
      return mem.remove(findById(id));

    }

    @Override
    public T findById(String id) {
       T finded = null;
        for (T memo : mem) {
            if (memo.getId() == id) {
                finded = memo ;
            }
        }
        return  finded;
    }

 //   public int memIndex(String id) {
  //      int i = 0 ;
  //      i = mem.indexOf(findById(id));
  //  }
}