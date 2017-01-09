import java.util.*;
import java.lang.*;
import java.io.*;
/*
6. Write a recursive function that, given two strings,
returns whether the first string is a subsequence of the second.
For example, given hac and cathartic, you should return true,
but given bat and table, you should return false.
*/

class RecursionSubsequence {

  public static boolean subsequence(String s1, String s2, int n, int m) {
    if (n >= s1.length() && s1.charAt(n-1) == s2.charAt(m-1)) return true;
    if (n >= s1.length() || m >= s2.length()) return false;

    char a = s1.charAt(n);
    char b = s2.charAt(m);
    if (a == b) return subsequence(s1, s2, n+1, m+1);
    return subsequence(s1, s2, n, m+1);
  }

  public static void main (String[] args) {
    String s1 = "bat";
    String s2 = "table";
    //String s1 = "hac";
    //String s2 = "cathartic";

    System.out.println(subsequence(s1,s2, 0, 0));
  }
}
