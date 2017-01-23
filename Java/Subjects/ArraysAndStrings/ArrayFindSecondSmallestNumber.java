import java.util.*;
import java.lang.*;
import java.io.*;

/*
Find the smallest and second smallest element in an array
Examples:
Input:  arr[] = {12, 13, 30, 10, 34, 13}
Output: The smallest element is 10 and
second Smallest element is 12
*/

class ArrayFindSecondSmallestNumber {

  // Time Complexity: O(n)
  public static int findSecondSmallestNumber(int[] input) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int e : input) {
      if (e < first) {
        second = first;
        first = e;
      } else if (e < second && e != first) {
        second = e;
      }
    }
    return second;
  }

  public static void main (String[] args) {
    int[] array = {12, 13, 30, 10, 34, 13};
    System.out.println(findSecondSmallestNumber(array));
  }
}
