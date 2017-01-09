import java.util.*;
import java.lang.*;
import java.io.*;
/*
37. A Patricia trie (sometimes called a radix trie) is a variation on a trie.
We'll say that a trie node is a “silly node” if it doesn't represent a word and
has exactly one child. A Patricia trie is a trie formed by removing all
the silly nodes from a trie and allowing edges to be labeled with arbitrary
strings, not just individual characters. Write a function that, given a trie,
converts it to a Patricia trie, and a reverse function that converts a Patricia
trie to a regular trie.

*/
class RadixTrie {
  public static class Node {
    String prefix;
    HashMap<String,Node> children;
    boolean isWord;
    public Node (String prefix) {
      this.prefix = prefix;
      this.children = new HashMap<String,Node>();
      this.isWord = false;
    }
  }

  public static Node createTrie(String[] dict) {
    Node root = new Node("");
    for (int i=0; i<dict.length; i++) {
      insertWord(root,dict[i]);
    }
    return root;
  }
  public static void insertWord(Node root, String word) {
    Node curr = root;
    for (int i=0; i<word.length(); i++) {
      if(!curr.children.containsKey(word.substring(i,i+1))) {
        curr.children.put(word.substring(i, i+1), new Node(word.substring(0, i+1)));
      }
      curr = curr.children.get(word.substring(i,i+1));
      if (i >= word.length()-1) curr.isWord = true;
    }
  }

  public static void convertToRadix(Node root) {
    if (root.children.size() == 1) {
      for (String childString : root.children.keySet()) {
        Node childNode = root.children.get(childString);
        root.prefix = root.prefix + childString;
        root.children.clear();
        root.children.put(childString, childNode);
      }
    } else {
      for (String s : root.children.keySet()) {
        convertToRadix(root.children.get(s));
      }
    }
  }

  public static void printTrie(Node root) {
    //if(root.isWord) System.out.println(root.prefix);
    System.out.println(root.prefix);
    for (String s : root.children.keySet()) {
      printTrie(root.children.get(s));
    }
  }

  public static void main (String[] args) {
    //String[] dictA = {"abc","aec", "abd", "a", "abe", "acc", "acb", "cba", "cbb"};
    String[] dictA = {"hola","holacaracola", "holajose", "holajoselito"};
    Node trieA = createTrie(dictA);
    printTrie(trieA);
    convertToRadix(trieA);
    System.out.println("---");
    printTrie(trieA);
  }
}
