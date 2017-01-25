import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write you own Power without using multiplication(*) and division(/) operators.
*/

class RecursionPow {

  public static int pow(int n, int pow) {
    System.out.println(pow);
    if (pow == 0) return 1;
    int result = pow(n, pow - 1);
    return multiply(n, result);
  }

  public static int multiply(int n, int i) {
    if ( i == 0) return 0;
    return n + multiply(n, i-1);
  }

  public static void main (String[] args) {
    int n = 4;
    int pow = 4;
    System.out.println(pow(n, pow));
  }
}
