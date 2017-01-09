import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a 2D array of 1s and 0s, find the largest square subarray all of 1s.
*/

class MatrixFindLargestSquare {

  public static void print(int[][] array) {
    for (int row=0; row<array.length; row++) {
      for (int col=0; col<array[0].length; col++) {
        System.out.print(array[row][col]);
      }
      System.out.println("");
    }
  }

  public static int findLargestSquare(int[][] array, int[][]sol, int r, int c, int largest) {
    System.out.println(r+","+c);
    if (c>= array[0].length) {
      return largest;
    }
    if (r>= array.length) {
      return largest;
    }

    if (array[r][c] == 1) {
      if (r == 0 || c == 0) {
        sol[r][c] = 1;
      } else {
        int value = Math.min(sol[r-1][c], sol[r][c-1]);
        value = Math.min(sol[r-1][c-1], value);
        sol[r][c] = ++value;
        if (sol[r][c] > largest) largest = sol[r][c];
      }
    }

    c++;
    if (c >= array[0].length) {
      c = 0;
      r++;
    }
    return findLargestSquare(array, sol, r, c, largest);
  }

  /*
  {{1,1,1,0},      {{1,1,1,0},
  {1,1,1,0},        {1,2,2,0},
  {1,1,1,0},        {1,2,2,0},
  {0,0,0,0}};       {0,0,0,0}};

  */
  public static void main (String[] args) {
    int[][] array = {{1,1,1,1},
                     {1,1,1,1},
                     {1,1,1,1},
                     {1,1,1,1}};
    print(array);
    int[][] sol = new int[array.length][array[0].length];
    System.out.println(findLargestSquare(array, sol, 0, 0, 0));
  }
}
