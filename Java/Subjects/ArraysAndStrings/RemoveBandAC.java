import java.util.*;
import java.lang.*;
import java.io.*;

/*
2
acbac
aababc
Output:

aaac
*/

class RemoveBandAC {

  public static String removeACPattern(String string) {
    // Use a StringBuilder in order to reduce time complexity
    StringBuilder sb = new StringBuilder();
    char last = ' ';

    // Iterate trough the chars of the String
    for (int i=0;i<string.length(); i++) {
      char cur = string.charAt(i);
      if (cur == 'b') {

      } else if (cur == 'c') {
        if (last == 'a') {
          sb.delete(sb.length()-1, sb.length());
        } else {
          sb.append(cur);
        }
      } else {
        sb.append(cur);
      }
      last = cur;
    }
    return sb.toString();
  }

  public static void main (String[] args) {
    String string = "aababc";
    System.out.println(removeACPattern(string));
	}
}
