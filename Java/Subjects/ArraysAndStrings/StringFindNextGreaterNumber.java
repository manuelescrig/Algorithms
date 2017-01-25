import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a number n, find the smallest number that has same set of digits as n and
is greater than n. If x is the greatest possible number with its set of digits,
then print “not possible”.
For simplicity of implementation, we have considered input number as a string.
e.g.
Input:  n = "218765"
Output: "251678"


Input:  n = "1234"
Output: "1243"
1234
  ^
queue = 4

1243

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"

*/

class StringFindNextGreaterNumber {

  public static String findNextGreaterNumber(String number) {
    if (number == null) return null;
    Queue<Character> queue = new LinkedList<Character>();
    queue.add(number.charAt(number.length()-1));

    StringBuilder sb = new StringBuilder();

    for (int i = number.length()-2; i >= 0; i--) {
      char curr = number.charAt(i);
      if (!queue.isEmpty() && curr < queue.peek()) {
        sb.append(number.substring(0,i));
        sb.append(queue.remove());
        sb.append(curr);
        System.out.println(queue.toString());
        while (!queue.isEmpty()) {
          sb.append(queue.remove());
        }
        break;
      } else {
        queue.add(curr);
      }
    }

    if (sb.length() == 0) return "Not possible";
    return sb.toString();
  }

  public static void main(String args[]) {
    System.out.println(findNextGreaterNumber("218765"));
    System.out.println(findNextGreaterNumber("1234"));
    System.out.println(findNextGreaterNumber("4321"));
    System.out.println(findNextGreaterNumber("534976"));
   }
}
