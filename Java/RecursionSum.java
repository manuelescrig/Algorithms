import java.util.*;
import java.lang.*;
import java.io.*;
/*
2. Write a recursive function that, given a number n,
returns the sum of the digits of the number n.
*/

class RecursionSum {

  public static int factorial(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    return n + factorial(n-1);
  }

  public static void main (String[] args) {
    int n = 4;
    System.out.println(factorial(n));
  }
}
