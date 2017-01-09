import java.util.*;
import java.lang.*;
import java.io.*;
/*
7. Given a list of n distinct elements,
write a function that lists all subsets of those elements.
*/

class RecursionSubsets {

  public static void subsets(int[] elements, int n, int m) {
    //System.out.println(n+","+m);

    if (n >= elements.length) return;
    if (m <= 0) return;
    if (n >= m) return;

    for (int i=n; i<m; i++) {
      System.out.print(elements[i] + " ");
    }
    System.out.println(",");

    subsets(elements, n+1, m);
    subsets(elements, n, m-1);
  }

  public static void main (String[] args) {
    int[] elements = {1,2,3,4,5};
    subsets(elements, 0, elements.length);
  }

  public static void print(int[] set) {
    System.out.print("[");
    for (int i=0; i<set.length-1; i++) {
      System.out.print(set[i] + ",");
    }
    System.out.print(set[set.length-1]+"]");
  }
}
