import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a string in a dictionary (hashSet) write a function to determine the
minumum number of characters to delete to make it a word.
dictionary = ["a", "aa", "aaa"]
query = "abc"
Output = 2
---
What if the query is not in the dictionary?
Can we add characters to the query?
---
             abc
         /    |   \
        ab    ac    bc
      /  \   /  \  /  \
     a   b  a   c b   c
    BFS

---
Time complexity n * n-1 * n-2 ... * 1 = O(n!) 

*/


class StringDeletion {

  public static int delete(String query, HashSet<String> dict) {

    HashSet<String> visited = new HashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(query);

    while (!queue.isEmpty()) {
      String string = queue.remove();
      System.out.println(string);
      if (dict.contains(string)) return query.length() - string.length();

      for (int i=0; i<string.length(); i++) {
        String temp = string.substring(0,i) + string.substring(i+1,string.length());
        if (temp.length() >0 && !visited.contains(temp)) {
          visited.add(temp);
          queue.add(temp);
        }
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    String query = "abc";
    HashSet<String> dict = new HashSet<String>();
    dict.add("a");
    dict.add("aa");
    dict.add("aaa");
    System.out.println(delete(query,dict));

   }
}
