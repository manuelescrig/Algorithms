import java.util.*;
import java.lang.*;
import java.io.*;

/*
How to print maximum number of A’s using given four keys.
Imagine you have a special keyboard with the following keys:
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
after what has already been printed.

If you can only press the keyboard for N times (with the above four
keys), write a program to produce maximum numbers of A's. That is to
say, the input parameter is N (No. of keys that you can press), the
output is M (No. of As that you can produce).
---
Examples:

Input:  N = 3
Output: 3
We can at most get 3 A's on screen by pressing
following key sequence.
A, A, A

Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

Input:  N = 11
Output: 27
We can at most get 27 A's on screen by pressing
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V, Ctrl A,
Ctrl C, Ctrl V, Ctrl V
*/

class DPMaxNumberOfAs {

  public static int findMaxA(int n) {
    return findMaxA(0, n, 0);
  }

  // Time complexity O(n!) factorial
  private static int findMaxA(int aCount, int keyLeft, int clipCount) {
    if (keyLeft == 0) return aCount;
    if (keyLeft < 0) return 0;

    int aPress = findMaxA(aCount + 1, keyLeft - 1, clipCount);
    int clipPaste = findMaxA(aCount + clipCount, keyLeft - 1, clipCount);
    int copyPaste = findMaxA(aCount + aCount, keyLeft - 3, aCount);
    return max(aPress, clipPaste, copyPaste);
  }

  public static int dpFindMaxA(int n) {
    HashMap<String,Integer> map = new HashMap<String, Integer>();
    return dpFindMaxA(map, 0, n, 0);
  }

  private static int dpFindMaxA(HashMap<String,Integer> map, int count, int keyLeft, int clipBoard) {
    if (keyLeft == 0) return count;
    if (keyLeft < 0) return 0;

    int aPress;
    String key = (keyLeft-1) + "-" + (count+1) + "-" + clipBoard;
    if (map.containsKey(key)) aPress = map.get(key);
    else {
      aPress = dpFindMaxA(map, count + 1, keyLeft - 1, clipBoard);
      map.put(key,aPress);
    }

    int clipPaste;
    key = (keyLeft-1) + "-" + (count+clipBoard) + "-" + clipBoard;
    if (map.containsKey(key)) clipPaste = map.get(key);
    else {
      clipPaste = dpFindMaxA(map, count + clipBoard, keyLeft - 1, clipBoard);
      map.put(key,clipPaste);
    }

    int copyPaste;
    key = (keyLeft-3) + "-" + (count+count) + "-" + count;
    if (map.containsKey(key)) copyPaste = map.get(key);
    else {
      copyPaste = dpFindMaxA(map, count + count, keyLeft - 3, count);
      map.put(key,copyPaste);
    }

    return max(aPress, clipPaste, copyPaste);
  }

  private static int max(int a, int b, int c){
    if (a >= b && a >= c) return a;
    if (b >= a && b >= c) return b;
    return c;
  }

  public static void main (String[] args) {
    int result = dpFindMaxA(11);
    System.out.println(result);
  }

}
