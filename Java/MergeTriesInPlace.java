import java.util.*;
import java.lang.*;
import java.io.*;
/*
34. Write a function that, given pointers to the roots of two tries,
returns a pointer to the root of a new trie that contains all the words
present in both tries.
*/
class MergeTriesInPlace {

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
    for (String word : dict) {
      insertWord(root, word);
    }
    return root;
  }
  public static void insertWord(Node trie, String word) {
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

  public static Node mergeTries(Node trieA, Node trieB) {
    merge(trieA, trieB);
    return trieA;
  }

  public static void merge(Node result, Node root) {
    if (root.isWord) insertWord(result, root.prefix);
    for (Character c : root.children.keySet()) {
      merge(result,root.children.get(c));
    }
  }

  public static void printTrie(Node root) {
    if (root.isWord) System.out.println(root.prefix);
    for (Character c : root.children.keySet()) {
      printTrie(root.children.get(c));
    }
  }
  public static void main (String[] args) {
    String[] dictA = {"abc", "ab", "cba", "cbb"};
    Node trieA = createTrie(dictA);
    //printTrie(trieA);

    String[] dictB = {"abc", "ab", "cba", "cbb", "cbc", "hola"};
    Node trieB = createTrie(dictB);
    //printTrie(trieB);

    Node trieC = mergeTries(trieA, trieB);
    printTrie(trieC);

  }
}
