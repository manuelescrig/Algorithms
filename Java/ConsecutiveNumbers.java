import java.util.*;
import java.lang.*;
import java.io.*;
/*
[4, 2, 1, 6, 5] => [4, 5, 6] => 3
[5, 5, 3, 1] => [5] [5] [1] => 1

*/

class ConsecutiveNumbers {

  public static int consecutive(int[] a) {
      HashSet<Integer> values = new HashSet<Integer>();
      for (int i : a) {
        values.add(i);
      }
      int max = 0;
      for (int i : values) {
        if (values.contains(i-1)) continue;
        int length = 0;
        while (values.contains(i++)) length++;
        max = Math.max(max, length);
      }
      return max;
  }

  public static void main (String[] args) {
    int[] a = {4,2,1,6,5};
    System.out.println(consecutive(a));
  }
}
