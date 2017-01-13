import java.util.*;
import java.lang.*;
import java.io.*;
/*
Questions
­1.Determine if a string is a palindrome
­2.Merge two sorted arrays
­3.Reverse an array in place
­4.Find substring
­5.All sorting algorithms
6.Binary search in a sorted rotated array
­7.Max profit stock problem
­8.Matrix multiplication
­9.Find all duplicates in an array
­10.Print a matrix in a spiral manner
11.Longest common substring
12.Generate substrings
*/

class Chapter_1_ArraysStrings {


  /*
  ­1.Determine if a string is a palindrome
  */
  public static boolean isPalindrome(String input) {

    for (int i=0; i<input.length()/2; i++) {
      char a = input.charAt(i);
      char b = input.charAt(input.length()-1-i);
      if (a != b) return false;
    }

    return true;
  }

  /*
  ­2.Merge two sorted arrays
  a = 123;
         ^
  b = 1223;
          ^
  r = 1122231;
            ^
  */
  public static int[] mergeSortedArrays(int[] a, int[] b) {
    int[] result = new int[a.length+b.length];

    int i=0;
    int j=0;
    int k=0;

    while (i < a.length || j < b.length) {
     if (j >= b.length || a[i] < b[j]) {
        result[k] = a[i];
        i++;
      } else if (i >= a.length || a[i] <= b[j]) {
        result[k] = b[j];
        j++;
      }
      k++;
    }

    return result;
  }

  /*
  ­3.Reverse an array in place
  input = {1,2,3,4,5,6,7,8,9}
  */
  public static void reverseInPlace(int[] input) {

    for (int i=0; i<input.length/2; i++) {
      int temp = input[i];
      input[i] = input[input.length - 1 - i];
      input[input.length - 1 - i] = temp;
    }
  }

  /*
  ­4.Find substring
  s   = Manuelito
               ^
  sub = eli
           ^
  */
  public static boolean findSubstring(String string, String subString) {

    int j = 0;
    for (int i = 0; i<string.length(); i++) {
      char a = string.charAt(i);
      if (j >= subString.length()) return true;
      char b = subString.charAt(j);
      if (a == b) {
          j++;
      } else {
        j = 0;
      }
    }

    if (j >= subString.length()) return true;
    else return false;
  }

  /*
  ­5.All sorting algorithms
  */
  public static void bubbleSort(int[] input) {

    boolean isSorted = false;
    while (isSorted == false) {
      isSorted = true;
      for (int i = 0; i < input.length - 1; i++) {
        if (input[i] > input[i+1]) {
          int temp = input[i+1];
          input[i+1] = input[i];
          input[i] = temp;
          isSorted = false;
        }
      }
    }
  }

  public static int[] mergeSort(int[] input) {
    if (input.length <= 1) return input;

    int[] first = Arrays.copyOfRange(input, 0, input.length/2);
    int[] second = Arrays.copyOfRange(input,input.length/2, input.length);
    mergeSort(first);
    mergeSort(second);
    merge(input,first,second);
    return input;
  }

  public static void merge(int[] list, int[] first, int[] second) {
    int i = 0; int j = 0; int k = 0;

    while (i < first.length || j < second.length) {
      if (i >= first.length) {
        list[k] = second[j];
        j++;
      } else if (j >= second.length) {
        list[k] = first[i];
        i++;
      } else if (first[i] < second[j]) {
        list[k] = first[i];
        i++;
      } else if (first[i] >= second[j]) {
        list[k] = second[j];
        j++;
      }
      k++;
    }
  }

  public static void quickSort(int[] input) {
    quickSort(input,0,input.length-1);
  }

  private static void quickSort(int[] a, int l, int r) {
    int index = partition(a, l, r);
    if (l < index - 1) quickSort(a,l,index - 1);
    if (index < r) quickSort(a,index,r);
  }

  private static int partition(int[] a, int l, int r) {
    int i = l;
    int j = r;
    int temp;
    int pivot = a[(l+r)/2];
    while (i <= j) {
      while (a[i] < pivot) i++;
      while (a[j] > pivot) j--;
      if (i <= j) {
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        i++;
        j--;
      }
    }
    return i;
  }

  /*
  6.Binary search in a sorted rotated array
  input = 1,2,3,4,5,6,7,8,9 (2)
          ^     ^
                ^
  */
  public static boolean binarySearch(int[] input, int target) {

    int left = 0;
    int right = input.length-1;
    while ((right - left) > 1) {
      int mid = (right - left) / 2;
      mid += left;
      if (input[mid] == target) return true;
      if (input[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return false;
  }

  /*                    0 1 2 3 4 5 6 7 8
  sortedRotatedArray = {4,5,6,7,8,9,1,2,3} (4)
                        ^ ^
                          ^
  */
  public static boolean binarySearchRotated(int[] input, int target) {
    int left = 0;
    int right = input.length-1;
    int mid = (right - left) / 2;

    while ( left < right ) {

      if (input[mid] == target) return true;
      if (input[mid] > target && input[left] <= target) {
        // Left Side
        right = mid;
        mid = (right - left) / 2;
      } else {
        // Right Side
        left = mid;
        mid = (right - left) / 2;
        if (mid == 0) mid++;
        mid += left;
      }
    }
    return false;
  }

  /*
  ­7.Max profit stock problem
  The cost of a stock on each day is given in an array, find the max profit
  that you can make by buying and selling in those days. For example, if the
  given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can
  earned by buying on day 0, selling on day 3. Again buy on day 4 and sell
  on day 6. If the given array of prices is sorted in decreasing order, then
  profit cannot be earned at all.
     0    1    2    3   4    5    6
  {100, 180, 260, 310, 40, 535, 695}
     0   80  160  210   0  495  655


  */
  public static void maxProfit(int[] input) {
    if (input == null) return;
    if (input.length < 1) return;

    int[] profits = new int[input.length];
    profits[0] = 0;
    for (int i = 1; i < input.length; i++) {
      if (input[i] > input[i-1]) {
        int diff = input[i] - input[i-1];
        profits[i] = profits[i-1] + diff;
      } else {
        profits[i] = 0;
      }
    }

    int prev = profits[0];
    System.out.print("0,");
    for (int i=1; i<profits.length; i++) {
      if (prev < profits[i]) {
        prev = profits[i];
      } else {
        System.out.println(i-1 + "|");
        System.out.print(i+",");
        prev = profits[i];
      }
    }
    System.out.println(input.length-1 + "|");

  }


  /*
  ­8.Matrix multiplication
  return c = a * b
    1 2 3  * 10 20 30 =  10  40  90
    4 5 6    40 50 60   160 250 360
    7 8 9    70 80 90   490 640 810

    i = 0
    j = 0
    k = 2

  */
    public static double[][] multiply(double[][] a, double[][] b) {
      int m1 = a.length;
      int n1 = a[0].length;
      int m2 = b.length;
      int n2 = b[0].length;
      if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
      double[][] c = new double[m1][n2];
      for (int i = 0; i < m1; i++)
          for (int j = 0; j < n2; j++)
              for (int k = 0; k < n1; k++)
                  c[i][j] += a[i][k] * b[k][j];
      return c;
  }


  /*
  ­9.Find all duplicates in an array
  */
  public static void method9(String input) {

  }

  /*
  ­10.Print a matrix in a spigral manner
  */
  public static void method10(String input) {

  }

  /*
  11. Given two strings, write a function that returns the longest common
  substring.
  Eg. subString("ABAB", "BABA") = "ABA"
  Eg. subString("ABCDE", "BACDE") = "CDE"
  */
  public static String longestCommonSubstring(String a, String b) {
    if (a.length() == 0 || b.length() == 0) return "";
    int[][] cache = new int[b.length()][a.length()];
    return lcs(a,b,cache, 0, 0, 0);
  }

  public static String lcs(String a, String b, int[][] cache, int row, int col, int max) {
    if (row >= b.length()) {
      for (int r=0; r<b.length(); r++) {
        for (int c=0; c<a.length(); c++){
          if (cache[r][c] == max) {
            System.out.println("found: "+c+","+r+","+max);
            return a.substring((c+1)-max, c+1);
          }
        }
      }
      return "";
    }

    if (b.charAt(row) == a.charAt(col)) {
      if (row == 0 || col == 0) {
        cache[row][col] = 1;
      } else {
        cache[row][col] = cache[row-1][col-1] + 1;
      }
      if (cache[row][col] > max) max = cache[row][col];
    }
    System.out.println(row+","+col+","+cache[row][col]);

    col++;
    if (col >= a.length()) {
      col = 0;
      row++;
    }

    return lcs(a,b,cache,row,col,max);
  }

  /*
  12.Generate substrings
  */
  public static ArrayList<String> generateSubstrings(String s) {
    ArrayList<String> result = new ArrayList<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(s);

    while (!queue.isEmpty()) {
      String temp = queue.remove();
      if (!result.contains(temp)) result.add(temp);
      // result.add(temp);
      for (int i=0; i<temp.length(); i++) {
          String a = temp.substring(0,i);
          if (!result.contains(a)) queue.add(a);
          String b = temp.substring(i+1);
          if (!result.contains(b)) queue.add(b);
      }
    }
    return result;
  }

  public static void main (String[] args) {

    System.out.println("1.Determine if a string is a palindrome");
    String palindrome = "manunam";
    System.out.println(isPalindrome(palindrome));
    String notPalindrome = "manuam";
    System.out.println(isPalindrome(notPalindrome));
    System.out.println("\n");

    System.out.println("2.Merge two sorted arrays");
    int[] arrX = {1,2,3};
    int[] arrY = {1,2,2,3};
    int[] arrR = mergeSortedArrays(arrX, arrY);
    for (int i : arrR) System.out.print(i + " ");
    System.out.println("\n");

    System.out.println("3.Reverse an array in place");
    int[] arrA = {1,2,3,4,5,6,7,8,9};
    reverseInPlace(arrA);
    for (int i : arrA) System.out.print(i + " ");
    System.out.println("\n");

    System.out.println("4.Find substring");
    String string = "Manuelito";
    String subString = "elito";
    System.out.println(findSubstring(string, subString));
    System.out.println("\n");

    int[] unsorted = {7,9,3,8,5,6,1,4,2};
    System.out.println("5.BubbleSort");
    //bubbleSort(unsorted);
    for (int i : unsorted) System.out.print(i + " ");
    System.out.println("\n");

    System.out.println("5.MergeSort");
    // mergeSort(unsorted);
    for (int i : unsorted) System.out.print(i + " ");
    System.out.println("\n");

    System.out.println("5.QuickSort");
    quickSort(unsorted);
    for (int i : unsorted) System.out.print(i + " ");
    System.out.println("\n");

    System.out.println("6.Binary search in a sorted array");
    int[] sortedArray = {1,2,3,4,5,6,7,8,9};
    System.out.println(binarySearch(sortedArray, 2));
    System.out.println("");

    System.out.println("6.Binary search in a sorted rotated array");
    int[] sortedRotatedArray = {4,5,6,7,8,9,1,2,3};
    System.out.println(binarySearchRotated(sortedRotatedArray, 10));
    System.out.println("");

    System.out.println("7.Max Profit");
    int[] stocks = {100, 180, 260, 310, 40, 535, 695};
    maxProfit(stocks);
    System.out.println("");

    System.out.println("11.Given two strings, write a function that returns the longest common substring.");
    String a = "ABAB";
    String b = "BABAB";
    System.out.println(longestCommonSubstring(a,b));
    System.out.println("\n");

    System.out.println("12.Generate substrings");
    ArrayList<String> resultA = generateSubstrings(a);
    System.out.println(resultA.toString());
    System.out.println("\n");
  }

}
