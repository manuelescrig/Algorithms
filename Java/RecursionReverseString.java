import java.util.*;
import java.lang.*;
import java.io.*;
/*
3. Write a recursive function that, given a string s,
prints the characters of s in reverse order.
*/

class RecursionReverseString {

  public static String reverse(String s, int n) {
    if (n == 0) return s.substring(0,n+1);
    return  s.substring(n,n+1) + reverse(s, n-1);
  }

  public static void main (String[] args) {
    String s = "Margo"; // ograM
    System.out.println(reverse(s, s.length()-1));
  }
}
