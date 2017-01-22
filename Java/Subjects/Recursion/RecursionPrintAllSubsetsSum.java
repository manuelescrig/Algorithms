import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a num­ber N, Write an algo­rithm to print
all pos­si­ble sub­sets with Sum equal to N.
Input:
4
Output:
1111
112
121
13
211
22
31
4
*/

class RecursionPrintAllSubsetsSum {

  public static void print(int n, String x) {
    if (n == 0) {
      System.out.println(x);
      return;
    } else {
      for (int i = 1; i <= n; i++) {
        x = x + i;
        print(n-i,x);
        x = x.substring(0,x.length()-1);
      }
    }
  }

  public static void main (String[] args) {
    int n = 4;
    print(n,"");
  }
}
