import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a function that, given a pointer to the root of a trie,
prints out all words in that trie.
*/

class Print {

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

  public static Node trie;

  public static void createTrie(String[] dict) {
    trie = new Node("");
    for (String word : dict) {
      insertWord(word);
    }
  }
  public static void insertWord(String word) {
    Node curr = trie;
    for (int i=0; i<word.length(); i++) {
      if (!curr.children.containsKey(word.charAt(i))) {
          curr.children.put(word.charAt(i),
                            new Node(word.substring(0,i+1)));
      }
      curr = curr.children.get(word.charAt(i));
      if (i == word.length() - 1) curr.isWord = true;
    }
  }

  public static void printTrie(Node root) {
    if (root.isWord) System.out.println(root.prefix);
    for (Character c : root.children.keySet()) {
      printTrie(root.children.get(c));
    }
  }
  public static void main (String[] args) {
    String[] dict = {"abc", "ab", "cba", "cbb"};
    createTrie(dict);
    printTrie(trie);

    //List <String> result = getWordsForPrefix("a");
    //System.out.println(result.toString());

  }
}
