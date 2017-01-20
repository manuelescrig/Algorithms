import java.util.*;
import java.lang.*;
import java.io.*;

/*
Example: apple -> eppla
Example: friend -> freind
*/

class ReverseVowels {
  public static void main (String[] args) {
    String string = "friend";
    //String string = "apple";

    HashSet<Character> set = new HashSet<Character>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');

    Stack<Character> stack = new Stack<Character>();
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<string.length(); i++) {
      char c = string.charAt(i);
      if (set.contains(c)) stack.push(c);
    }

    for (int i=0; i<string.length(); i++) {
      char c = string.charAt(i);
      if (set.contains(c))  {
        sb.append(stack.pop());
      } else {
        sb.append(c);
      }
    }

    System.out.println(sb.toString());
  }
}
