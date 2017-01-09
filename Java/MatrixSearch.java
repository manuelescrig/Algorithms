import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a nxm array where all rows and columns are in sorted order
write a function to determine whether the array contains an element x.

[  0,  1,  2,  3]
[  4,  5,  6,  7]
[  8,  9, 10, 11]
[ 12, 13, 14, 15]

find(10) = true;
find(20) = false;

target  = 0
row     = 3
col     = 0

*/

class MatrixSearch {

  public static boolean contains(int[][] matrix, int number) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    int row = 0;
    int col = matrix.length - 1;

    while (row < matrix[0].length && col >= 0) {
      if (matrix[row][col] == number) return true;
      if (matrix[row][col] < number) row++;
      else col--;
    }
    return false;
  }

  public static boolean find(int[][] matrix, int target) {
    int row = matrix.length-1;
    int col = matrix[0].length-1;
    if (target > matrix[row][col]) return false;

    boolean found = false;
    while(found == false) {
      if (col < 0) return false;
      if (target == matrix[row][col]) return true;
      if (row == 0 || target > matrix[row-1][col]) col--;
      else row--;
    }
    return found;
  }

  public static void main (String[] args) {
    int[][] matrix = {{0,1,2,3},
    {4,5,6,7},
    {8,9,10,11},
    {12,13,14,15}};
    System.out.println(contains(matrix,10));
  }
}
