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
        int ind = indexOf(id);
        boolean retVal;
        if (ind != -1)  {
            mem.set(ind, model);
            retVal = true;
        } else {
            retVal = false;
        }

     return retVal;
    }

    @Override
    public boolean delete(String id) {
        int ind = indexOf(id);
        boolean retVal;
       if (ind != -1) {
           mem.remove(ind);
           retVal = true;
       } else {
         retVal = false;
       }
         return  retVal;

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

    public int memIndex(String id) {
       int i = 0 ;
       i = mem.indexOf(findById(id));
       return i;
   }

  private  int indexOf(String id) {
        int index = -1;
        for(int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return  index;
  }

}