import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a function that, given a pattern string consisting of a series
of letters intermixed with question marks (for example, a string like do?ble)
and a pointer to the root of a trie, returns all words in the trie that match
the pattern, where a question mark matches any single character. If given the
pattern do?ble, for example, and a trie of all words in English, your code
should return doable and double. Given the pattern ??, it would return a
list of all two-letter words in English.
*/

class TriePattern {
  public static class Node {
    String prefix;
    HashMap<Character, Node> children;
    boolean isWord;
    public Node(String prefix) {
      this.prefix = prefix;
      this.children = new HashMap<Character, Node>();
      this.isWord = false;
    }
  }

  public static Node createTrie(String[] dict) {
    Node root = new Node("");
    for (String s : dict) {
      insertWord(root,s);
    }
    return root;
  }

  public static void insertWord(Node root, String word) {
    Node curr = root;
    for (int i=0; i<word.length(); i++) {
      if (!curr.children.containsKey(word.charAt(i))) {
        curr.children.put(word.charAt(i), new Node(word.substring(0,i+1)));
      }
      curr = curr.children.get(word.charAt(i));
      if (i >=  word.length()-1) curr.isWord = true;
    }
  }

  public static void printTrie(Node root) {
    if (root.isWord) System.out.println(root.prefix);
    for (char c : root.children.keySet()) {
      printTrie(root.children.get(c));
    }
  }

  public static List<String> findWords(Node root, char[] pattern) {
    List<String> result = new LinkedList<String>();
    findWord(result,root,pattern, 0);
    return result;
  }
  public static void findWord(List<String> result, Node root, char[] pattern, int n) {
    for (char c : root.children.keySet()) {
      if(n < pattern.length) {
        //System.out.println(pattern[n]  + "," + c + "," + n +","+root.isWord);
        if (pattern[n] == c || pattern[n] == '?') {
          if (n == pattern.length-1)
            shouldAddChildren(result, root.children.get(c));
          findWord(result,root.children.get(c), pattern, n+1);
        }
      }
    }
  }
  public static void shouldAddChildren(List<String> result, Node root) {
    if (root.isWord) result.add(root.prefix);
  }

  public static void main (String[] args) {
    String[] dictA = {"abc","aec", "abd", "a", "abe", "acc", "acb", "cba", "cbb"};
    Node trieA = createTrie(dictA);
    printTrie(trieA);
    System.out.println("---");
    String pattern = "a?c";
    List<String> result = findWords(trieA, pattern.toCharArray());
    System.out.println(result.toString());
  }
}
