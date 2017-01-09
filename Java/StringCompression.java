import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a String, write a function to compress it by shortening every sequence
of the same character to that character followed by the number of repetitions.
If the compressed String is longer than the original you should return the
original.
e.g.
compress("a") = a
compress("abc") = abc
compress("aaa") = a3
compress("aaabbb") = a3b3
compress("aaabccc") = a3b1c3
*/

class StringCompression {

  public static String compress(String s) {
    if (s == null || s.length() < 2) return s;

    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i=0; i<s.length()-1; i++) {
      char curr = s.charAt(i);
      char next = s.charAt(i+1);
      if (curr != next) {
          sb.append(curr);
          sb.append(count);
          count=1;
        } else {
          count++;
        }
    }

    sb.append(s.charAt(s.length()-1));
    sb.append(count);

    if (sb.length() < s.length()) return sb.toString();
    else return s;
  }


  public static void main(String args[]) {
    System.out.println(compress("a"));
    System.out.println(compress("aaa"));
    System.out.println(compress("aaabbb"));
    System.out.println(compress("aaabccc"));
   }
}
