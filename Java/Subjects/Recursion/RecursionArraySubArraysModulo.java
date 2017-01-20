import java.util.*;
import java.lang.*;
import java.io.*;
/*
Maximum Subarray Sum.
Generate all subarrays of an array and return the max of the modulo k of
the subarrays.

A = 3 3 9 9 5
k = 7
Result = 6

0,0
0,1
0,2
0,3
0,4
1,1
1,2
1,3
1,4
2,2
2,3
2,4
3,3
3,4
4,4

*/

class RecursionArraySubArraysModulo {

  public static void subsets(int[] elements, int n, int m) {
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


  public static int subArrays(int[] a, int k, int n) {
    if (n == a.length-1) {  return 0; }

    int max = Integer.MIN_VALUE;
    for (int i=n; i<a.length; i++) {
      System.out.println(i+","+n);
      int[] temp  = Arrays.copyOfRange(a,n,i+1);
      int modulo = modulo(temp,k);
      if (modulo > max) max = modulo;
    }
    subArrays(a,k,n+1);

    return max;
  }

  public static int modulo(int[] a, int k) {
    int sum = 0;
    for (int x : a) {
      sum += x;
    }
    return sum % k;
  }

  public static void print(int[] a) {
    for (int x : a) {
      System.out.print(x + " ");
    }
    System.out.println(" ");
  }

  public static void main (String[] args) {
    int[] a = {3,3,9,9,5};
    int k = 7;
    int result = subArrays(a,k,0);
    System.out.println(result);
  }
}
