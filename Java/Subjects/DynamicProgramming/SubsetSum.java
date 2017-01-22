import java.util.*;
import java.lang.*;
import java.io.*;

/*
Subset sum problem is to find subset of elements that are selected from a
given set whose sum adds up to a given number K. We are considering the set
contains non-negative values.
It is assumed that the input set is unique (no duplicates are presented).

int[] A = { 3, 2, 7, 1}, S = 6
Output: True, subset is (3, 2, 1}
*/

public class SubsetSum {

  // Dynamic Programing version
  public static boolean subSetDP(int[] A, int sum) {
    boolean[][] solution = new boolean[A.length + 1][sum + 1];
    // If sum is not zero and subset is 0, we can't make it
    for(int i=1;i<=sum;i++){
      solution[0][i]=false;
    }
    // If sum is 0 the we can make the empty subset to make sum 0
    for(int i=0;i<=A.length;i++){
      solution[i][0]=true;
    }

    for(int i=1;i<=A.length;i++){
      for(int j=1;j<=sum;j++){
        //First copy the data from the top
        solution[i][j] = solution[i-1][j];

        // If solution[i][j]==false check if can be made
        if(solution[i][j]==false && j>=A[i-1])
        solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];
      }
    }
    return solution[A.length][sum];
  }

  // Iterative version BFS
  public static int[] subsetSum(int[] a, int k) {
    if (a == null) return null;
    HashSet<int[]> visited = new HashSet<int[]>();
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.add(a);
    visited.add(a);

    while (!queue.isEmpty()) {
      int[] temp = queue.remove();
      if (sum(temp) == k) return temp;

      for  (int i=0; i<temp.length; i++) {
        int[] pre = Arrays.copyOfRange(temp,0,i);
        int[] suf = Arrays.copyOfRange(temp,i+1, temp.length);
        int[] next = new int[pre.length + suf.length];
        System.arraycopy(pre, 0, next, 0, pre.length);
        System.arraycopy(suf, 0, next, pre.length, suf.length);

        if (!visited.contains(next)) {
          queue.add(next);
          visited.add(next);
        }
      }
    }

    return null;
  }

  public static int sum(int[] a) {
    int sum = 0;
    for (int e : a) {
      sum += e;
    }
    return sum;
  }

  public static void print(int[] a) {
    for (int e : a) {
      System.out.print(e + " ");
    }
    System.out.println(" ");
  }

  public static void main(String args[]) {
    int[] a = {3,2,7,1};
    int k = 6;
    int[] result = subsetSum(a,k);
    print(result);

    System.out.println("\n");
    subSetDP(a,k);
  }
}
