package ru.meta.chap1;
import java.util.Collections;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ArrConsoleFill {

 private  int shortest = 0;
   private int longest = 0;
   private int[] arr = new int[10];



    public static  void main (String[] args) {
        ArrConsoleFill arrCF = new ArrConsoleFill();
   int temp =0 ;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  for (int i=0; i < arrCF.arr.length; i++) {
     try {
         temp = Integer.parseInt(reader.readLine());
     }
     catch (java.io.IOException e) {
         System.err.println("Exception: " + e);
     }
      arrCF.arr[i] = temp;

  }

    try {
        for(int pt : arrCF.arr) {
            System.out.println(pt);
        }

    } catch (java.io.IOError e) {
        System.err.println("Exception: " + e);
    }
        arrCF.getShortestLongest();
        arrCF.printLongest();
        arrCF.printShortest();

}

private void  getShortestLongest() {
    int longest ; int shortest ; int  val = 0;
    val = String.valueOf(arr[0]).length();
    longest = val; shortest = val;
        for (int i=1; i < arr.length; i++ ) {
        val = String.valueOf(arr[i]).length();
       // shortest = String.valueOf(arr[i]).length();
        longest = (longest > val) ? longest : val;
        shortest = (shortest < val) ? shortest : val;
    }
        this.longest = longest;
        this.shortest = shortest;
}

private void printShortest() {
System.out.println("Shortest value is " + this.shortest);
}

private void printLongest() {
    System.out.println("Longeest value is " + this.longest);
}

private void printSortAsc() {

    }

    private void printSortDesc() {

    }
    
}
