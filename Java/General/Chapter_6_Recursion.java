import java.util.*;
import java.lang.*;
import java.io.*;
/*
Questions Recursion (Backtracking)
1.Fibonacci
­2.Find all permutations or combinations
­3.Find all possible subsets
­4.Queens problem
­5.Convert numbers into words according to letters on an old phone keypad
*/

class Chapter_6_Recursion {

  /*
  1.Fibonacci
  */
  public static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n-1) + fibonacci(n-2);
  }

  /*
  2.Array, unique permutations
  Given a collection of numbers that might contain duplicates,
  return all possible unique permutations.
.
  For example, [1,1,2] have the following unique permutations:
  [1,1,2], [1,2,1], and [2,1,1].
  */
  public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
  	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
  	result.add(new ArrayList<Integer>());

  	for (int i = 0; i < num.length; i++) {
  		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
  		for (List<Integer> l : result) {
  			for (int j = 0; j < l.size() + 1; j++) {
  				l.add(j, num[i]);
  				ArrayList<Integer> T = new ArrayList<Integer>(l);
  				l.remove(j);
  				currentSet.add(T);
  			}
  		}
  		returnList = new ArrayList<ArrayList<Integer>>(currentSet);
  	}

  	return returnList;
  }

  /*
  2.Array, print all combinations of size k.
  input = {1, 2, 3, 4}
  r = 2
  output = {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}
  */
  // Option A
  // Time complexity O(2^n) Exponential
  public static void combinations(int[] a, int k, int[] temp, int start, int end, int index) {
    if (index == k) {
      for (int j=0; j<k; j++)
        System.out.print(temp[j]+" ");
      System.out.println("");
      return;
    }
    for (int i=start; i<=end && end-i+1 >= k-index; i++) {
      temp[index] = a[i];
      combinations(a, k, temp, i+1, end, index+1);
    }
    return;
  }

  public static void printCombination(int arr[], int n, int k) {
        int data[]=new int[k];
        combinations(arr, k, data, 0, n-1, 0);
  }
  // Option B
  // Time complexity O(2^n) Exponential
  public static void combinationUtil(int a[], int r, int currLen, int data[], int i) {
      if (currLen == r) {
        for (int j=0; j<r; j++)
          System.out.print(data[j]+" ");
        System.out.println("");
        return;
      }

      if (i >= a.length) return;
      data[currLen] = a[i];
      combinationUtil(a, r, currLen+1, data, i+1);
      combinationUtil(a, r, currLen, data, i+1);
  }

  public static void printCombinationB(int arr[], int r) {
      int data[]=new int[r];
      combinationUtil(arr, r, 0, data, 0);
  }

  /*
  3.Array. Find all the subsets of a given set.
  Input:
  S = {a, b, c, d}
  Output:
  {}, {a} , {b}, {c}, {d}, {a,b}, {a,c}, {a,d}, {b,c}, {b,d}, {c,d}, {a,b,c},
  {a,b,d}, {a,c,d}, {b,c,d}, {a,b,c,d}
  */
  // Option A
  public static void printSubsets(int set[]) {
    int n = set.length;

    // Run a loop for printing all 2^n
    for (int i = 0; i < (1<<n); i++) {
      System.out.print("{ ");

      // Print current subset
      for (int j = 0; j < n; j++)
      if ((i & (1 << j)) > 0) System.out.print(set[j] + " ");
      System.out.println("}");
    }
  }
  // Option B
  public static void printSubsets(int[] B, int[] A, int x) {
    if (x == A.length - 1) {
      A[x] = 0;
      printArray(B, A);
      A[x] = 1;
      printArray(B, A);
      return;
    }
    A[x] = 0;
    printSubsets(B, A, x + 1);
    A[x] = 1;
    printSubsets(B, A, x + 1);
  }

  public static void printArray(int[] B, int[] A) {
    boolean isNULL = true;
    System.out.print("{");
    for (int i = 0; i < B.length; i++) {
      if (A[i] == 1) {
        System.out.print(B[i] + "");
        isNULL = false;
      }
    }
    if (isNULL == false) {
      System.out.print("}");
      System.out.print("  ");
    } else {
      System.out.print("Empty");
      System.out.print("} ");
    }
  }


  public static void main (String[] args) {
    System.out.println("1.Fibonacci");
    System.out.println(fibonacci(7));
    System.out.println("-");


    System.out.println("2.Array, unique permutations");
    int[] perms = {1, 1, 2};
    ArrayList<ArrayList<Integer>> result = permuteUnique(perms);
    System.out.println(result.toString());
    System.out.println("-");

    System.out.println("2.Array, print all combinations of size k");
    int arr[] = {1, 2, 3, 4, 5};
    int r = 2;
    int n = arr.length;
    printCombination(arr, n, r);
    System.out.println("-");
    printCombinationB(arr, r);
    System.out.println("-");

    System.out.println("3.Array. Find all the subsets of a given set.");
    int[] set = {1, 2, 3};
    int[] temp = new int[set.length];
    printSubsets(set);
    printSubsets(set,temp,0);
    System.out.println("-");


  }
}
