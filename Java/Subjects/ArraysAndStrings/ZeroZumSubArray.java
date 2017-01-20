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

    // Create a HashMap to keep tracks of the current sum values
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Current sum
    int currentSum = 0;

    // Iterate once trough the array
    for (int i=0; i<=array.length; i++) {
      map.put(currentSum,i);
      if (i < array.length) {
        currentSum += array[i];
      } else {
        return null;
      }
      if (map.containsKey(currentSum)) {
        // Copy Array from 0 to current value
        int start = map.get(currentSum);
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
