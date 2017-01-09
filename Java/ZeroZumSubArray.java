import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given an Array, write a function to find any subarray that sums to zero, if
one exists.

zeroSum({1,2,-5,1,2,-1}) = [2,-5,1,2]

Array =  1,  2, -5,  1,  2,  1
         1   3  -2  -1   1   2
         2   1  -1   4   3   1

sum = 1
map = {0,0} {1,1} {3,2} {-2,3} {-1,4}
*/

class ZeroZumSubArray {

  public static int THREE_SUM_TARGET = 0;

  public static int[] zeroSum(int[] array) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    int sum = 0;
    for (int i=0; i<=array.length; i++) {
      map.put(sum,i);
      if (i < array.length) {
        sum += array[i];
      } else {
        return null;
      }
      if (map.containsKey(sum)) {
        int start = map.get(sum);
        int end = i--;
        return Arrays.copyOfRange(array, start, end+1);
      }
    }

    return null;
  }

  public static void main (String[] args) {

    int[] list = {1,2,-5,1,2,-1};

    int[] result = zeroSum(list);
    for(int j=0; j<result.length; j++) {
      System.out.print(result[j] + " ");
    } System.out.println(" ");
  }
}
