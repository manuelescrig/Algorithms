import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a method that takes as input a 2D array and returns
a new 2D array which is its transpose.
1 2  =>   1
          2
1 2  =>   1 3
3 4       2 4

1 2  =>   1 3 5
3 4       2 4 6
5 6
*/

class MatrixTranspose {

  public static void print(int[][] matrix) {
    for (int rows = 0; rows < matrix.length; rows++) {
      for (int cols = 0; cols < matrix[0].length; cols++) {
        System.out.print(matrix[rows][cols] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] transpose(int[][] matrix) {
    int[][] result = new int[matrix[0].length][matrix.length];
    for (int cols = 0; cols < matrix[0].length; cols++) {
      for (int rows = 0; rows < matrix.length; rows++) {
        result[cols][rows] = matrix[rows][cols];
      }
    }
    return result;
  }

  public static void main (String[] args) {
    int[][] matrix = {{1,2},{3,4},{5,6}};
    print(matrix);
    print(transpose(matrix));
  }
}
