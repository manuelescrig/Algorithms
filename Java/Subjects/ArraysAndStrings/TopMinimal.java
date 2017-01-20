import java.util.*;
import java.lang.*;
import java.io.*;

/*
Find the top minimal m elements of n elements in O(n) time

m = 3
{1,2,3,4,5,6,7,8,9,10} -> {1,2,3}

m = 3
{20,4,5,6,9,10,14,15,2} -> {2,4,5}

Option 1:
Sort the array and the return a sub array with the first m elements.
O(n logn)

Option 2:
Iterate trough the array and put the integers in a priority queue. Then pop
the m elements from the priority queue.
O(n)
[20,,]
[4,20,]
[4,5,20]
[4,5,6]
[2,4,5]

*/

class TopMinimal {

  public static ArrayList<Integer> minimalElements(int[] elements, int m) {

    // Create the result array
    ArrayList<Integer> result = new ArrayList<Integer>(m);
    for (int e : elements) {
      if (result.isEmpty()) {
        result.add(e);
      } else {

        // For each element check if is bigger than the others
        for (int i=0; i<m; i++) {
          if (e < result.get(i)) {
            result.add(i,e);
            break;
          }
        }
      }
    }
    return result;
  }

  public static void main (String[] args) {
    int m = 3;
    int[] elements = {20,4,5,6,9,10,14,15,2};
    ArrayList<Integer> result = minimalElements(elements,m);
    for (int i=0; i<m; i++) {
      System.out.println(result.get(i));

    }
  }
}
