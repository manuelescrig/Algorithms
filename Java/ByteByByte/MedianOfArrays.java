import java.util.*;

/*
Find the median of two sorted arrays.

arr1 = [​1​, ​3​, ​5​]
arr2 = [​2​, ​4​, ​6​] 
median(arr1, arr2) = ​3.5
*/

class MedianOfArrays {

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
