import java.util.*;
import java.lang.*;
import java.io.*;

/*
Dynamic Programming Questions
*/

class CCIDynamicProgramming {

  /*
  8.1 Triple Step: A child is running up a staircase with n steps
  and can hop either 1 step, 2 steps, or 3 steps at a time.
  Implement a method to count how many possible ways
  the child can run up the stairs.
  */
  public static int countSteps(int n) {
    if (n < 0 ) return 0;
    if (n == 0) return 1;

    return countSteps(n-1) + countSteps(n-2) + countSteps(n-3);
  }

  public static int countStepsMem(HashMap<String, Integer> map, int n) {
    if (n < 0 ) return 0;
    if (n == 0) return 1;

    int total = 0;
    for (int i = 1; i<4; i++) {
      String key = n + "-" + (n-i);
      if (map.containsKey(key)) {
        total += map.get(key);
      } else {
        int value = countStepsMem(map, n-i);
        map.put(key, value);
        total += value;
      }
    }
    return total;
  }

  /*
  8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of grid
  with r rows and c columns. The robot can only move in two directions, right
  and down, but certain cells are "off limits" such that the robot cannot step
  on them. Design an algorithm to find a path for the robot from the top left
  to the bottom right.
  */

  public static int countPath(int[][] grid, int col, int row) {
    if (col >= grid[0].length) return 0; // Off limits
    if (row >= grid.length) return 0; // Off limits
    if (grid[col][row] == 1) return 0; // Found obstacle
    if (col == grid[0].length - 1 && row == grid.length - 1) return 1;

    return countPath(grid, col+1, row) + countPath(grid, col, row+1);
  }

  public static int countPathMem(HashMap<String, Integer> map, int[][] grid, int col, int row) {
    if (col >= grid[0].length) return 0; // Off limits
    if (row >= grid.length) return 0; // Off limits
    if (grid[col][row] == 1) return 0; // Found obstacle
    if (col == grid[0].length - 1 && row == grid.length - 1) return 1;

    String key1 = col+1 + "-" + row;
    int val1;
    if (map.containsKey(key1)) {
      val1 = map.get(key1);
    } else {
      val1 = countPathMem(map, grid, col+1, row);
      map.put(key1,val1);
    }
    String key2 = col + "-" + row+1;
    int val2;
    if (map.containsKey(key2)) {
      val2 = map.get(key2);
    } else {
      val2 = countPathMem(map, grid, col, row+1);
      map.put(key2,val2);
    }

    return val1 + val2;
  }

  public static String printPath(int[][] grid, int col, int row, String path) {
    if (col >= grid[0].length) return ""; // Off limits
    if (row >= grid.length) return ""; // Off limits
    if (grid[col][row] == 1) return ""; // Found obstacle
    if (col == grid[0].length - 1 && row == grid.length - 1) return " Path: " + path;

    String pos = "("+col+","+row+")";
    // System.out.print(pos + " ");
    return printPath(grid, col+1, row, path + pos) + printPath(grid, col, row+1, path + pos);
  }


  /*
  8.3 Magic Index: A magic index in an array A[1. .. n-1] is defined to be
  an index such that A[i] = i. Given a sorted array of distinct integers,
  write a method to find a magic index, if one exists, in array A.
  */
  public static int sortedMagicIndex(int[] array, int start, int end) {
    if (start > end) return -1;
    int mid = (start + end)/2;
    if (array[mid] == mid) return mid;
    if (array[mid] > mid) {
      return sortedMagicIndex(array, start, mid);
    } else {
      return sortedMagicIndex(array, mid, end);
    }
  }

  public static int magicIndex(int[] array, int start, int end) {
    if (start > end) return -1;
    int mid = (start + end)/2;
    if (array[mid] == mid) return mid;
    /*Search left*/
    int leftIndex = Math.min(mid - 1, array[mid]);
    int left = magicIndex(array, start, leftIndex);
    if (left >= 0) { return left;}

    /*Search right*/
    int rightIndex = Math.max(mid + 1, array[mid]);
    int right = magicIndex(array, rightIndex, end);
    return right;
  }

  /*
  8.4 Power Set: Write a method to return all subsets of a set.
  */
  public static ArrayList<ArrayList<Integer>> subSets(ArrayList<ArrayList<Integer>> sets,
  int[] a, int n, int m) {
    if (n <= 0) {
      sets.add(new ArrayList<Integer>());
      return sets;
    }

    ArrayList<Integer> temp = new ArrayList<Integer>();
    for (int i=m; i<n+m; i++) {
      temp.add(a[i]);
    }
    sets.add(temp);

    if (m+n >= a.length) return subSets(sets, a, n-1, 0);
    else return subSets(sets, a, n, m+1);
  }

  /*
  8.5 Recursive Multiply: Write a recursive function to multiply two positive
  integers without using the * operator (or / operator). You can use addition,
  subtraction, and bit shifting, but you should minimize the number of those
  operations.
  */
  public static int multiply(int a, int b) {
    if (b <= 1) return a;
    return a + multiply(a,b-1);
  }

  /*
  8.6 Towers of Hanoi: You have 3 towers and N disks of different sizes which
  can slide onto any tower. The puzzle starts with disks sorted in ascending
  order of size from top to bottom. You have the following constraints:
  (1) Only one disk can be moved at a time.
  (2) A disk is slid off the top of one tower onto another tower.
  (3) A disk cannot be placed on top of a smaller disk.
  Write a program to move the disks from the first tower to the last with stacks.

  1
  2
  3
  |___| |___| |___|
  */
  //                                           A          B          C
  public static void doTowers(int topN, char from, char buffer, char to) {
    if (topN == 1) {
      System.out.println("Disk 1 from " + from + " to " + to);
    } else {
      doTowers(topN - 1, from, to, buffer);
      System.out.println("Disk " + topN + " from " + from + " to " + to);
      doTowers(topN - 1, buffer, from, to);
    }
  }

  /* (Backtracking)
  8.7 Permutation without duplicates. Write a method to compute all
  permutations of a string of unique chars.
  - When the order doesn't matter, it is a Combination.
  - When the order does matter it is a Permutation.
  - A Permutation is an ordered Combination. Permuation == Position
  - {1,2,3}, => (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), and (3,2,1)
  - ABC => ABC ACB BAC BCA CBA CAB
  */
  public static void permutations(String prefix, String s) {
    int n = s.length();
    if (n == 0) System.out.println(prefix);
    else {
      for (int i = 0; i < n; i++)
        permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
    }
  }


  /* (Backtracking)
  8.8 Permutations with Dups. Write a method to compute all permutations of a
  string whose characters are not necessarily unique.
  The list of permutations should not have duplicates.
  Input:  str[] = "AB"
  Output: AB BA
  Input:  str[] = "AA"
  Output: AA
  Input:  str[] = "ABC"
  Output: ABC ACB BAC BCA CBA CAB
  Input:  str[] = "ABA"
  Output: ABA AAB BAA
  Input:  str[] = "ABCA"
  Output: AABC AACB ABAC ABCA ACBA ACAB BAAC BACA BCAA CABA CAAB CBAA
  */


  public static void main (String[] args) {

    // 8.1 Triple Step
    // System.out.println(countSteps(35));
    // HashMap<String, Integer> map = new HashMap<String, Integer>();
    // System.out.println(countStepsMem(map, 35));

    // 8.2 Robot in a Grid
    int[][] grid = {{0,0,1,0,0,0},
    {0,0,0,0,0,0},
    {0,0,1,0,0,0},
    {0,0,1,0,0,0},
    {0,0,1,0,0,0},
    {0,0,1,0,0,0}};
    // System.out.println(countPath(grid, 0,0));
    // HashMap<String, Integer> map = new HashMap<String, Integer>();
    // System.out.println(countPathMem(map, grid, 0,0));
    // System.out.println(printPath(grid, 0,0, ""));

    // 8.3 Magic Index
    //               0,  1, 2,3,4,5,6,7,8,9,10
    // int[] array = {-40,-20,-1,1,2,3,5,7,9,12,13};
    // System.out.println(sortedMagicIndex(array, 0, array.length-1));
    //               0,  1, 2,3,4,5,6,7,8,9,10
    // int[] array = {-10,-5,2,2,2,3,4,7,9,12,13};
    // System.out.println(magicIndex(array, 0, array.length-1));

    // 8.4 Return all subsets
    // int[] set = {1,2,3}; // {}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3};
    // ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    // result = subSets(result, set, set.length, 0);
    // System.out.println(result.toString());

    // 8.5 Recursive Multiply
    //System.out.println(multiply(6,6));

    // 8.6 Towers of Hanoi;
    // Stack<Integer> s1 = new Stack<Integer>();
    // s1.push(3);
    // s1.push(2);
    // s1.push(1);
    // Stack<Integer> s2 = new Stack<Integer>();
    // Stack<Integer> s3 = new Stack<Integer>();
    // // towers(s1,s2,s3,3);
    // int nDisks = 3;
    // doTowers(nDisks, 'A', 'B', 'C');

    // 8.7 Permutation without duplicates.
    // String str = "a";
    String str = "abc";
    permutations("", str);
  }

}
