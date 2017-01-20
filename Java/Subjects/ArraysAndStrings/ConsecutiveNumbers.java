import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an array of integers find the number of consecutive numbers.
[4, 2, 1, 6, 5] => [4, 5, 6] => 3
[5, 5, 3, 1] => [5] [5] [1] => 1
*/

class ConsecutiveNumbers {

  public static int consecutive(int[] a) {
      // Create a HashSet and add all the values - Time complexity O(n)
      HashSet<Integer> values = new HashSet<Integer>();
      for (int i : a) {
        values.add(i);
      }

      int max = 0;

      // Iterate trough the values of the HashSet - Time complexity O(n)
      for (int i : values) {
        // If the value before exists then continue
        if (values.contains(i-1)) continue;

        // If the value does not exist get the length of this set - Time O(n)
        int length = 0;
        while (values.contains(i++)) length++;

        // Keep the max
        max = Math.max(max, length);
      }
      return max;
  }

  public static void main (String[] args) {
    int[] a = {4,2,1,6,5};
    System.out.println(consecutive(a));
  }
}
