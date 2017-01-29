import java.util.*;
import java.lang.*;
import java.io.*;

/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
to [5,6,7,1,2,3,4].

[1,2,3,4,5,6,7]
[4,3,2,1,5,6,7]
[4,3,2,1,7,6,5]
[5,6,7,1,2,3,4]

How many different ways do you know to solve this problem?
*/

class RotateArray {

  public static void print(int[] array) {
    System.out.print("{ ");
      for (int e : array) {
        System.out.print(e + " ");
      }
      System.out.println("}");
  }

  public static void rotateArray(int[] array, int k) {
    if (array == null || array.length == 0 || k <= 0) {
      throw new IllegalStateException("Invalid Parameters");
    }

    if ( k > array.length) {
      k = k % array.length;
    }

    // Length of first part
  	int a = array.length - k;
    reverse(array, 0, a-1);
    reverse(array, a, array.length-1);
    reverse(array, 0, array.length-1);
  }

  public static void reverse(int[] array, int left, int right) {

    while (left < right) {
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }


  public static void main (String[] args) {
    int[] array = {1,2,3,4,5,6,7};
    int k = 3;
    rotateArray(array, k);
    print(array);
  }

}
