import java.util.*;
import java.lang.*;
import java.io.*;
/*
4. Write a recursive function that checks whether a string is a palindrome
(a palindrome is a string that's the same when reads forwards and backwards.)
*/

class RecursionPalindrome {

  public static boolean palindrome(String s, int start,  int end) {
    System.out.println(start+","+end);

    if (start > end) return false;
    if (!s.substring(start, start+1).equals(s.substring(end, end+1))) return false;
    if (start > s.length()/2) return true;

    palindrome(s, ++start, --end);
    return  true;
  }

  public static void main (String[] args) {
    String s = "Margo"; // No
    //String s = "manunam"; // Yes
    //String s = "maneenam"; // Yes

    System.out.println(palindrome(s, 0, s.length()-1));
  }
}
