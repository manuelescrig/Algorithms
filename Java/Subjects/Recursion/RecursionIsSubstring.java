import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a recursive function that, given two strings,
returns whether the first string is a subsequence of the second.
For example, given hac and cathartic, you should return true,
but given bat and table, you should return false.
*/

class RecursionIsSubstring {

  public static boolean subsequence(String s1, String s2, int n) {
    if (n > s2.length() - s1.length()) return false;

    boolean isSubsequence = true;
    for (int i=0; i<s1.length();i++) {
      // System.out.println(s1.charAt(i)+","+s2.charAt(i+n));
      if (s1.charAt(i) != s2.charAt(i+n)) isSubsequence = false;
    }
    if (isSubsequence) return true;
    return subsequence(s1, s2, n+1);
  }

  public static void main (String[] args) {
    String s1 = "har";
    String s2 = "cathartic";

    System.out.println(subsequence(s1,s2, 0));
  }
}
