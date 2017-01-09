import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement: numeronymErstellen(string s){...}
Example: Hause -> H3e, markus -> m4s
*/

class StringBuilderCounter {

  public static void main (String[] args) {
    //String string = "Hause";
    String string = "markus";

    StringBuilder sb = new StringBuilder();
    sb.append(string.charAt(0));
    sb.append(string.length()-2);
    sb.append(string.charAt(string.length()-1));
    System.out.println(sb.toString());
  }
}
