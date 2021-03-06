package ru.job4j.generics;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
     mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int ind = indexOf(id);
        if (ind == -1)  {
          return false;
        }
        mem.set(ind, model);
     return true;
    }

    @Override
    public boolean delete(String id) {
        int ind = indexOf(id);
        boolean retVal;
       if (ind == -1) {
           return false;
       }
           mem.remove(ind);
           return true;
       }

    @Override
    public T findById(String id) {
       int ind = indexOf(id);
      if (ind == -1) {
          return null;
      }
        return  mem.get(ind);
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
    @Override
  public  void lstArray () {

      Iterator<T> itr = mem.iterator();
      while(itr.hasNext()){
          System.out.println(itr.next().getId());
      }



  }

}