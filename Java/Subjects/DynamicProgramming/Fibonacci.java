import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a N number  write a function to compute the nth fibonnaci number.

N = 6  => 1+1+2+3+5+8+13+21
N = 1  => 1 = 1
N = 2  => 1+1 = 2
N = 0  => 0

n + n-1 + n-2 + n-3  ... n-n => O(n!)

*/

class Fibonacci {

  public static int fibonnaci(int n) {
    if (n==0) return 0;
    if (n==1) return 1;
    return fibonnaci(n-1) + fibonnaci(n-2);
  }

  //   n = 3
  // map = {1-1,1} {
  // 1

  public static int fibonnaciMemoizaton(HashMap<String,Integer>map, int n) {
    if (n==0) return 0;
    if (n==1) return 1;

    String key1 = n+"-1";
    String key2 = n+"-2";
    int sum = 0;
    if(map.containsKey(key1)) {
      sum += map.get(key1);
    } else {
      int r = fibonnaciMemoizaton(map,n-1);
      map.put(key1,r);
      sum += r;
    }

    if (map.containsKey(key2)) {
      sum += map.get(key2);
    } else {
      int r = fibonnaciMemoizaton(map,n-2);
      map.put(key2,r);
      sum += r;
    }
    return sum;
  }

  public static void main (String[] args) {

    int n = 39;
    int result = fibonnaci(n);
    System.out.println(result);

    // HashMap<String,Integer> map = new HashMap<String, Integer>();
    // int result = fibonnaciMemoizaton(map, n);
    // System.out.println(result);

  }


}
