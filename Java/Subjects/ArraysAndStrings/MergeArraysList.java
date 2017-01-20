import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given two sorted A and B, where A is long enough to hold the contents of A and
B, write a function to copy the contents of B into A without using any buffer
or additional memory.
eg.
A = {1,3,5}
B = {2,4,6}

A => {3, 4, 6, 10, 11, 15}
j                         ^
B => {1, 5, 8, 12, 14, 19}
k                   ^

R => {1,  3,  4,  5,  6,  8, 10, 11,  12,  14,  15,  0}
i                                                ^
*/

class MergeArraysList {

  public static int[] mergeArrays(int[] A, int[] B) {
    if (A == null || A.length == 0) return B;
    if (B == null || B.length == 0) return A;

    // Create a copy for the results Time Complexity O(n)
    int[] result = new int[A.length+B.length];

    int j = 0;
    int k = 0;
    for (int i=0; i<result.length; i++) {
      if (j > A.length-1) {
        result[i] = B[k];
        k++;
      } else if (k > B.length-1) {
        result[i] = A[j];
        j++;
      } else if (A[j] > B[k]) {
        result[i] = B[k];
        k++;
      } else {
        result[i] = A[j];
        j++;
      }
    }

    return result;
  }

  // Merge a list of sorted lists
  public static int[] meregeListArrays(ArrayList<int[]> list) {
    // Get the length of all the lists
    int sum = 0;
    for (int[] array : list) {
      sum += array.length;
    }

    // Will hold a reference fo the indexes for the lists
    int[] indexes = new int[list.size()];

    // Store the result
    int[] result = new int[sum];

    // Iterate trough the result from start to end - Time Complexity O(n)
    for (int i=0; i<result.length; i++) {
      int smallest = Integer.MAX_VALUE;
      int index = 0;
      for (int j=0; j<list.size(); j++) {
        int[] array = list.get(j);
        if (indexes[j] < array.length) {
          int value = array[indexes[j]];
          if (value < smallest) {
            smallest = value;
            index = j;
          }
        }
      }
      indexes[index]++;
      result[i] = smallest;
    }

    return result;
  }

  public static void print(int[] arr) {
    System.out.print("{");
    for(int value : arr) {
      System.out.print(value+",");
    }
    System.out.println("}");
  }

  public static void main (String[] args) {
    int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
    int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
    int[] alicesArrayB = new int[]{1, 5, 8, 12, 14, 19};

    int[] result = mergeArrays(myArray, alicesArray);
    print(result);
    // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]

    ArrayList<int[]> arrays = new ArrayList<int[]>();
    arrays.add(myArray);
    arrays.add(alicesArray);
    arrays.add(alicesArrayB);
    int[] res = meregeListArrays(arrays);
    print(res);
  }
}
