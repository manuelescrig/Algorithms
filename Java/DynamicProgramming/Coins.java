import java.util.*;
import java.lang.*;
import java.io.*;
/*
Making change. Given an input x, write a function to determine the minimum
number of coins required to make the exact change.

int[] coins = {25,10,5,1};
change(32) = 4

*/

class Coins {

  public static int change(int[] coins, int x) {
    int[] cache = new int[x];
    Arrays.fill(cache, -1);
    return change(cache, coins, x);
  }

  public static int change(int[] cache, int[] coins, int x) {
    if (x == 0) return 0;

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (x - coin >= 0) {
        int result;
        if (cache[x-coin] >= 0) result = cache[x-coin];
        else {
          result = change(coins,x-coin) + 1;
          cache[x-coin] = result;
        }
        if (result < min) min = result;
      }
    }

    return min;
  }

  public static void main (String[] args) {
    int[] coins = {25,10,5,1};
    int change = change(coins, 32);
    System.out.println(change);
  }

}
