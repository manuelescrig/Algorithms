import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given two strings, write a function that returns the longest common substring.

eg.
longestSubstring("ABAB", "BABA") = "ABA"
*/

class DPLongestCommonSubstring {

  public static String longestSubstring(String a, String b) {
    String out = "";
    if (a.length() == 0 || b.length() == 0) return out;

    int len = 0;
    int[][] cache = new int[a.length()][b.length()];

    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j)) {
          if (i == 0 || j == 0) {
            cache[i][j] = 1;
          } else {
            cache[i][j] = cache[i-1][j-1] + 1;
          }
          if (cache[i][j] > len) {
            len = cache[i][j];
            out = a.substring(i - len + 1, i+1);
          }
        }
      }
    }
    return out;
  }

  public static int getLongestCommonSubstring(String a, String b){
    int m = a.length();
    int n = b.length();
    int max = 0;
    int[][] dp = new int[m][n];

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (a.charAt(i) == b.charAt(j)) {
          if (i==0 || j==0) {
            dp[i][j]=1;
          } else {
            dp[i][j] = dp[i-1][j-1]+1;
          }
          if (max < dp[i][j]) max = dp[i][j];
        }
      }
    }

    return max;
  }

  public static int getLongestCommonSubsequence(String a, String b){
  	int m = a.length();
  	int n = b.length();
  	int[][] dp = new int[m+1][n+1];

  	for (int i=0; i<=m; i++) {
  		for (int j=0; j<=n; j++){
  			if (i==0 || j==0) {
  				dp[i][j]=0;
  			} else if(a.charAt(i-1)==b.charAt(j-1)) {
  				dp[i][j] = 1 + dp[i-1][j-1];
  			} else {
  				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
  			}
  		}
  	}
  	return dp[m][n];
  }

  public static void main (String[] args) {
    String result = longestSubstring("manuel", "ue");
    System.out.println(result);
  }

}
