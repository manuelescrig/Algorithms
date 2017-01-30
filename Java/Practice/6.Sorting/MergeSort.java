import java.util.*;
import java.lang.*;
import java.io.*;

/*
Sort a linked list in O(n log n) time using constant space complexity.
*/

class MergeSort {


  public static int[] mergeSort(int [] list) {
    if (list.length <= 1) return list;

    // Split the array in half
    int[] first = new int[list.length / 2];
    int[] second = new int[list.length - first.length];
    System.arraycopy(list, 0, first, 0, first.length);
    System.arraycopy(list, first.length, second, 0, second.length);

    // Sort each half
    mergeSort(first);
    mergeSort(second);

    // Merge the halves together, overwriting the original array
    merge(first, second, list);
    return list;
  }

  private static void merge(int[] first, int[] second, int [] result) {
    // Merge both halves into the result array
    // Next element to consider in the first array
    int iFirst = 0;
    // Next element to consider in the second array
    int iSecond = 0;

    // Next open position in the result
    int j = 0;
    // As long as neither iFirst nor iSecond is past the end, move the
    // smaller element into the result.
    while (iFirst < first.length && iSecond < second.length) {
      if (first[iFirst] < second[iSecond]) {
        result[j] = first[iFirst];
        iFirst++;
      } else {
        result[j] = second[iSecond];
        iSecond++;
      }
      j++;
    }
    // Copy what's left
    System.arraycopy(first, iFirst, result, j, first.length - iFirst);
    System.arraycopy(second, iSecond, result, j, second.length - iSecond);
  }

  public static void main(String args[]) throws Exception {
    int[] x = { 9, 2, 4, 7, 3, 7, 10 };
    System.out.println(Arrays.toString(x));

    mergeSort(x);
    System.out.println(Arrays.toString(x));
  }
}
