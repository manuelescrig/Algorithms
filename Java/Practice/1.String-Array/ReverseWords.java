import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an input string, reverse the string word by word.
A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces
and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
           ^         ^
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/

class ReverseWords {

  // s = "is blue the sky  ",
  //          ^         ^

  public static String reverseWords(String s) {
    if (s == null) throw new IllegalStateException("Invalid input.");
    if (s.length() == 0) return s;

    StringBuilder sb = new StringBuilder("");
    for(int i = s.length() - 1; i >= 0; i--) {
      if(Character.isWhitespace(s.charAt(i))) {
        sb.append(s.substring(i + 1, s.length() - sb.length())).append(" ");;
      }
    }

    sb.append(s.substring(0, s.length() - sb.length()));
    return sb.toString();
  }

  public static void main (String[] args) {
    String s = "the sky is blue";
    System.out.println(reverseWords(s));
  }

}
