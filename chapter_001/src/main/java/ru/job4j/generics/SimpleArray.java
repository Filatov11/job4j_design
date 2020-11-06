package ru.job4j.generics;

import java.util.Arrays;
import java.util.Objects;

public class SimpleArray<T>  {
    T[] uniArr;
    public  SimpleArray(T[] arr) {
        uniArr = arr;
    }

    public int  firstEmpty() {
        int i = 0;
        while ( (this.uniArr[i] != null) &&  (i < this.uniArr.length) ) {
            i++;
        }
        return i;

    }

    public void   add(T model) {
        this.uniArr[firstEmpty()] = model;
    }

    public  void  set(int index, T model) {
      this.uniArr[index] = model;
    }

    public void remove(int index)  {
         T[] temp;
         temp = Arrays.copyOfRange(this.uniArr, index, this.uniArr.length-1);
        System.arraycopy(temp, 0, this.uniArr, index, temp.length);
        for (int i = (index+ temp.length)-1; i < this.uniArr.length; i++ ) {
            this.uniArr[i] = null;
        }
    }


    public boolean checkIndex(int index) {
           boolean cInd;
        if  (this.uniArr.length > index)
        {cInd = true;}  else
        {cInd = false;}
        return  cInd;

    }
    public T get(int index) {
        T retVal ;
        //if  (this.uniArr.length > index)
        try {
            retVal = this.uniArr[index - 1];

        }

            catch (Exception e) {

                // throws Exception
                System.out.println("Exception : " + e);
              retVal = null;
        }

        return retVal;
        }

    }



