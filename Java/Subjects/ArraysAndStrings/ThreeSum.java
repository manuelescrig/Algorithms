import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a list of integers, write a function that returns all sets of 3 numbers in
the list that the sum equals to 0;
threSum({-1,0,1,2,-1,4})

[-1,-1,2]
[-1,0,1];

a   =>  -4,  -1,  -1,  0,  1,  2,
         ^
              ^    ^
*/

class ThreeSum {

  public static int THREE_SUM_TARGET = 0;

  public static ArrayList<int[]> threeSum(int[] a) {
    // Create the ArrayList to return the arrays of integers
    ArrayList<int[]> result = new ArrayList<int[]>();

    // Sort input array O(nlogn)
    Arrays.sort(a);

    // Iterate trough the elements of the array O(n)
    for (int i=0; i<a.length - 3; i++) {
        int y = i+1;
        int z = a.length-1;

        // Create a window with first element,second and last
        while (y < z) {
          if (THREE_SUM_TARGET == a[i] + a[y] + a[z]) {
            int[] found = {a[i], a[y], a[z]};
            result.add(found);
            break;
          } else if (a[i] < a[y] + a[z]) {
            z--;
          } else {
            y++;
          }
        }
    }

    return result;
  }

  public static void main (String[] args) {

    int[] list = {-1,0,1,2,-1,4};
    // int[] list = {1,2,3,4};
    ArrayList<int[]> result = threeSum(list);
    for (int[] l : result) {
      for(int j=0; j<l.length; j++) {
        System.out.print(l[j] + " ");
      } System.out.println(" ");
    }
  }
}
