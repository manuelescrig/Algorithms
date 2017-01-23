import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an array and a number k where k is smaller than size of array,
we need to find the k’th smallest element in the given array.
It is given that all array elements are distinct.
Examples:
Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 4
Output: 10
---
Method 1 (Simple Solution)
A Simple Solution is to sort the given array using a O(nlogn) sorting algorithm
like Merge Sort, Heap Sort, etc and return the element at index k-1 in the
sorted array.
Time Complexity of this solution is O(nLogn).
---
Method 2 (Using Min Heap – HeapSelect)
We can find k’th smallest element in time complexity better than O(nLogn).
A simple optomization is to create a Min Heap of the given n elements and call extractMin() k times.
Time complexity of this solution is O(n + kLogn).
*/

class ArrayFindKthSmallestNumber {

  // Time complexity is O(nlog(k)).
  // Space complexity is O(k) for storing the top k numbers.
  public static int findKthSmallestNumber(int[] input, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int e : input) {
      pq.add(e);
    }
    int result = 0;
    for (int i = 0; i < k; i++ ){
      result = pq.remove();
    }
    return result;
  }

  public static void main (String[] args) {
    int[] array = {12, 13, 30, 10, 34, 13};
    System.out.println(findKthSmallestNumber(array, 4));
  }
}
