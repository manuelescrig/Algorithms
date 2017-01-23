import java.util.*;
import java.lang.*;
import java.io.*;

/*
You are given a list of n-1 integers and these integers are in the range of 1 to n.
There are no duplicates in list. One of the integers is missing in the list.
Write an efficient code to find the missing integer.Examples:
Example:
I/P    [1, 2, 4, ,6, 3, 7, 8]
O/P    5

*/

class ArrayFindMissingNumber {

  // Time Complexity: O(n)
  public static int findMissingNumber(int[] a, int n) {
    int i = 0;
    int total = 0;

    total  = (n+1)*(n+2)/2;
    for ( i = 0; i< n; i++) total -= a[i];
    return total;
  }

  public static void main (String[] args) {
    int[] array = {1, 2, 4, 6, 3, 7, 8};
    System.out.println(findMissingNumber(array, 7));
  }
}
