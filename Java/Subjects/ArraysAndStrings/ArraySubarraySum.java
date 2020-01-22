import java.util.*;
import java.io.*;

/*
Given an unsorted array of nonnegative integers, find a continous subarray
which adds to a given number.

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
*/

class ArraySubarraySum {

// Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
// sum      = 33
// curr_sum = 33
// start    = 1
// i        = 5
// n        = 6
  int subArraySum(final int arr[], final int n, final int sum) {

    int curr_sum = arr[0];
    int start = 0;
    int i;

    for (i = 1; i <= n; i++) {

      while (curr_sum > sum && start < i-1) {
        curr_sum = curr_sum - arr[start];
        start++;
      }

      if (curr_sum == sum) {
        final int p = i-1;
        System.out.println("Sum found between indexes " + start + " and " + p);
        return 1;
      }

      if (i < n) curr_sum = curr_sum + arr[i];
    }
    System.out.println("No subarray found");
    return 0;
  }

  public static void main(final String[] args) {
    final DPSubArraysSum arraysum = new DPSubArraysSum();
    final int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
    final int n = arr.length;
    final int sum = 23;
    arraysum.subArraySum(arr, n, sum);
  }

}
