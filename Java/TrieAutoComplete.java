import java.util.*;
import java.lang.*;
import java.io.*;
/*
Trie Example
*/
class TrieAutoComplete {

  public static class Node {
    String prefix; // abc
    HashMap<Character,Node> children;
    boolean isWord;
    public Node(String prefix) {
      this.prefix = prefix;
      this.children = new HashMap<Character, Node>();
    }
  }

  public static Node trie;

  public static void autocomplete(String[] dict) {
    trie = new Node("");
    for (String s : dict) {
      insertWord(s);
    }
  }

  private static void insertWord(String s) {
      Node n = trie;
      for (int i=0; i<s.length(); i++) {
        if(!n.children.containsKey(s.charAt(i))) {
          n.children.put(s.charAt(i),
          new Node(s.substring(0,i+1)));
        }
        n = n.children.get(s.charAt(i));
        if (i == s.length()-1) {
          n.isWord = true;
        }
      }
  }

  public static List<String> getWordsForPrefix(String pre) {
    List<String> results = new LinkedList<String>();
    Node curr = trie;
    for (char c : pre.toCharArray()) {
      if (curr.children.containsKey(c)) {
        curr = curr.children.get(c);
      } else {
        return results;
      }
    }
    findAllChildWords(curr, results);
    return results;
  }
  private static void findAllChildWords(Node n, List<String> results) {
    if (n.isWord) results.add(n.prefix);
    for (Character c : n.children.keySet()) {
      findAllChildWords(n.children.get(c), results);
    }
  }

  public static void main (String[] args) {
    String[] dict = {"abc", "ab", "cba", "cbb"};
    autocomplete(dict);
    List <String> result = getWordsForPrefix("a");
    System.out.println(result.toString());

  }
}
