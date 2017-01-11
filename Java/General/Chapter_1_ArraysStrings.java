import java.util.*;
import java.lang.*;
import java.io.*;
/*
Questions
­1.Determine if a string is a palindrome
­2.Merge two sorted arrays
­3.Reverse an array in place
­4.Find substring
­5.All sorting algorithms
6.Binary search in a sorted rotated array
­7.Max profit stock problem
­8.Matrix multiplication
­9.Find all duplicates in an array
­10.Print a matrix in a spiral manner
11.Longest common substring

*/

class Chapter_1_ArraysStrings {

  /*
  11. Given two strings, write a function that returns the longest common
  substring.
  Eg. subString("ABAB", "BABA") = "ABA"
  Eg. subString("ABCDE", "BACDE") = "CDE"


  */
  public static String longestCommonSubstring(String a, String b) {
    if (a.length() == 0 || b.length() == 0) return "";
    int[][] cache = new int[b.length()][a.length()];
    return lcs(a,b,cache, 0, 0, 0);
  }

  public static String lcs(String a, String b, int[][] cache, int row, int col, int max) {
    if (row >= b.length()) {
      for (int r=0; r<b.length(); r++) {
        for (int c=0; c<a.length(); c++){
          if (cache[r][c] == max) {
            System.out.println("found: "+c+","+r+","+max);
            return a.substring((c+1)-max, c+1);
          }
        }
      }
      return "";
    }

    if (b.charAt(row) == a.charAt(col)) {
      if (row == 0 || col == 0) {
        cache[row][col] = 1;
      } else {
        cache[row][col] = cache[row-1][col-1] + 1;
      }
      if (cache[row][col] > max) max = cache[row][col];
    }
    System.out.println(row+","+col+","+cache[row][col]);

    col++;
    if (col >= a.length()) {
      col = 0;
      row++;
    }

    return lcs(a,b,cache,row,col,max);
  }


  public static ArrayList<String> generateSubstrings(String s) {
    ArrayList<String> result = new ArrayList<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(s);

    while (!queue.isEmpty()) {
      String temp = queue.remove();
      if (!result.contains(temp)) result.add(temp);
      // result.add(temp);
      for (int i=0; i<temp.length(); i++) {
          String a = temp.substring(0,i);
          if (!result.contains(a)) queue.add(a);
          String b = temp.substring(i+1);
          if (!result.contains(b)) queue.add(b);
      }
    }
    return result;
  }

  public static void main (String[] args) {
    String a = "ABAB";
    String b = "BABAB";
    System.out.println(longestCommonSubstring(a,b));

    ArrayList<String> resultA = generateSubstrings(a);
    System.out.println(resultA.toString());
  }

}
