import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a list of n distinct elements,
write a function that lists all permutations of that list.
{1,2} => {1,2} {2,1}
{1,2,3} => {1,2,3} {2,1,3} {1,3,2} {3,2,1}
{1,2,3,4} => {1,2,3,4} {2,1,3,4} {1,3,2,4} {3,2,1,4}
*/

class PermutationsArray {

  public static void permutations(int[] elements, int n) {
    if (n >= elements.length-1) return;

    for (int i=n; i<elements.length; i++) {
      int temp = elements[n];
      elements[n] = elements[i];
      elements[i] = temp;
      print(elements);
    }

    permutations(elements, n+1);
    return;
  }

  public static void print(int[] set) {
    System.out.print("[");
    for (int i=0; i<set.length-1; i++) {
      System.out.print(set[i] + ",");
    }
    System.out.print(set[set.length-1]+"]");
  }

  public static void main (String[] args) {
    int[] elements = {1,2,3,4,5};
    //int[] elements = {1,2,3};
    permutations(elements, 0);
    }

}
