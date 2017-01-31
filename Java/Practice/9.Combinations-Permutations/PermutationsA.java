import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

class PermutationsA {

  public static ArrayList<ArrayList<Integer>> permuteIterative(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    // Start from an empty list
    result.add(new ArrayList<Integer>());

    for (int i = 0; i < num.length; i++) {
      System.out.println("result  = " + result.toString());

      // List of list in current iteration of the array num
      ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
      System.out.println("current = " +  current.toString());

      for (ArrayList<Integer> l : result) {

        // Number of locations to insert is largest index + 1
        for (int j = 0; j < l.size()+1; j++) {
          System.out.println("l       = " +  current.toString());

          // Add num[i] to different locations
          l.add(j, num[i]);

          ArrayList<Integer> temp = new ArrayList<Integer>(l);
          current.add(temp);
          // System.out.println(temp);

          // Remove num[i] add
          l.remove(j);
        }
      }

      result = new ArrayList<ArrayList<Integer>>(current);
    }

    return result;
  }

  public static ArrayList<ArrayList<Integer>> permuteRecursive(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    permute(num, 0, result);
    return result;
  }

  private static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
    System.out.println("start = " + start + " result = " + result.toString());

    // Base case
    if (start >= num.length) {
      ArrayList<Integer> item = convertArrayToList(num);
      result.add(item);
    }

    // Iterate
    for (int j = start; j <= num.length - 1; j++) {
      swap(num, start, j);
      permute(num, start + 1, result);
      swap(num, start, j);
    }
  }

  private static ArrayList<Integer> convertArrayToList(int[] num) {
    ArrayList<Integer> item = new ArrayList<Integer>();
    for (int h = 0; h < num.length; h++) {
      item.add(num[h]);
    }
    return item;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


  public static void main (String[] args) {
    int[] x = { 1,2,3 };
    // ArrayList<ArrayList<Integer>> resultA = permuteIterative(x);
    // System.out.println(resultA.toString());

    ArrayList<ArrayList<Integer>> resultB = permuteRecursive(x);
    System.out.println(resultB.toString());
  }
}
