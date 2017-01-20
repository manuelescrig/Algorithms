import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a recursive implementation of the factorial function.
Recall that n! = 1 × 2 × ... × n, with the special case that 0! = 1.
*/

class RecursionFactorial {

  public static int factorial(int n) {
    if (n == 0) return 1;
    if (n == 1) return 1;

    return n * factorial(n-1);
  }

  public static void main (String[] args) {
    int n = 4;
    System.out.println(factorial(n));
  }
}
