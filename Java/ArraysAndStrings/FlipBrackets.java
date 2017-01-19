import java.util.*;
import java.lang.*;
import java.io.*;

/*

Q) Given the string of brackets. Return the minimum number of flips needed to make the string look like a balanced bracket expression. You can only flip the brackets ({->} and }->{), delete or add is not allowed. No additional space can be used here.

Constraint: Can't use additional space (O(n) space) like Array or Set etc

Examples:
}{ -> 2 flips will give {}
{}{}{} -> No flips required
{{{} -> 1 flip (second bracket) is required
{{{}}}{} -> No flips required
{{}} -> No flips required
{}}} -> 1 flips required
{{{{ -2 2 flips
{}{{{{{{
}}{{ => {}{}, {{}}

I/P: String: Representing the expresion
O/P: Integer: Number of flips

counter = 4;
openBrackets = 2;
closedBrackets = 2;
*/

class FlipBrackets {

  public static int findMininumNumber(String s) {
    int counter = 0;
    int brackets = 0;

    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if (c=='{') {
        brackets++;
      } else if (c=='}') {
        if (brackets==0) {
          brackets++;
          counter++;
        } else {
          brackets--;
        }
      } else {
        return -1;
      }
    }

    return counter + brackets/2;
  }

  public static void main (String[] args) {
    System.out.println(findMininumNumber("}{"));
    System.out.println(findMininumNumber("{{{}"));
  }
}
