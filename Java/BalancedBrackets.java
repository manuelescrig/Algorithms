import java.util.*;
import java.lang.*;
import java.io.*;

/*

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

*/

class BalancedBrackets {

  public static int hasBalancedBrackets(String str)
{
    if (str == null) return 1;
    if (str.length() == 0) return 1;

      Stack<Character> stack = new Stack<Character>();
      for (int i=0; i<str.length(); i++) {
          char c = str.charAt(i);
          if (c == '(' || c == '{' || c == '[' || c == '<') {
              stack.push(c);
          } else if (c == ')' || c == '}' || c == ']' || c == '>') {
              if (stack.isEmpty()) return 0;
              char bracket = stack.pop();
              if (c == ')' && bracket != '(') return 0;
              if (c == '}' && bracket != '{') return 0;
              if (c == ']' && bracket != '[') return 0;
              if (c == '>' && bracket != '<') return 0;
          }
      }
      if (stack.isEmpty()) return 1;
      else return 0;
}

  public static void main (String[] args) {
    System.out.println(hasBalancedBrackets("}{"));
    System.out.println(hasBalancedBrackets("{{{}"));
  }
}
