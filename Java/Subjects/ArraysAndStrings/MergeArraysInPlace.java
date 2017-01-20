import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given two sorted A and B, where A is long enough to hold the contents of A and
B, write a function to copy the contents of B into A without using any buffer
or additional memory.
eg.
A = {1,3,5,0,0,0}
B = {2,4,6}

A => 1  2  3  4  5  6
i    ^
j    ^
B => 2  4  6
k  ^
*/

class MergeArraysInPlace {

  public static void copy(int[] A, int[] B) {
    if (B.length > A.length) throw new IllegalArgumentException("Array B must be smaller than Array A.");
    int j = B.length-1;
    int k = (A.length - B.length) - 1;

    // Iterate trough the bigger array from the end to the start O(n)
    for (int i=A.length-1; i>=0; i--) {
      if (k < 0 || j < 0) break;

      // Check for the biggest element
      if (B[k] > A[j]) {
         A[i] = B[k];
         k--;
      } else {
         A[i] = A[j];
         A[j] = 0;
         j--;
      }
    }
  }

  public static void print(int[] arr) {
    System.out.print("{");
    for(int value : arr) {
      System.out.print(value+",");
    }
    System.out.println("}");
  }

  public static void main (String[] args) {
    int[] A = {1,3,5,0,0,0};
    int[] B = {2,4,6};
    try {
      copy(A,B);
    } catch (Exception e) {
      e.printStackTrace();
    }
    print(A);
  }
}
