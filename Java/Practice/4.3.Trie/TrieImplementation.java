import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a trie with insert, search, and startsWith methods.
A trie node should contains the character, its children and the flag that marks if it is a leaf node.
*/

class TrieImplementation {

  public static class TrieNode {
    char value;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isWord;
    public TrieNode() {}
      public TrieNode(char value) {
        this.value = value;
      }
    }

    public static class Trie {
      private TrieNode root;

      public Trie() {
        root = new TrieNode();
      }

      public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i=0; i < word.length(); i++) {
          char c = word.charAt(i);
          TrieNode t;
          if (children.containsKey(c)) {
            t = children.get(c);
          } else {
            t = new TrieNode(c);
            children.put(c,t);
          }
          children = t.children;
          if (i == word.length() - 1) t.isWord = true;
        }
      }

      public boolean search(String word) {
        TrieNode t = searchNode(word);
        if (t != null && t.isWord == true) return true;
        else return false;
      }

      public TrieNode searchNode(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i=0; i < word.length(); i++) {
          char c = word.charAt(i);
          if (children.containsKey(c)) {
            t = children.get(c);
            children = t.children;
          } else {
            return null;
          }
        }
        return t;
      }

      public boolean startsWith(String prefix) {
        if (searchNode(prefix) != null) return true;
        else return false;
      }

      public void print() {
        recurse("", root);
      }

      public void recurse(String string, TrieNode root) {
        if (root == null) return;
        if (root.isWord) {
          System.out.println(string);
        }
        for (TrieNode node : root.children.values()) {
          recurse(string + node.value, node);
        }
      }


      public boolean searchPattern(String word) {
        return dfsSearch(root.children, word, 0);
      }

      public boolean dfsSearch(Map<Character, TrieNode> children, String word, int start) {
        if (start == word.length()) {
          if (children.size() == 0) return true;
          else return false;
        }

        char c = word.charAt(start);
        if (children.containsKey(c)) {
          if (start == word.length() - 1 && children.get(c).isWord) {
            return true;
          }
          return dfsSearch(children.get(c).children, word, start+1);
        } else if (c == '*') {
          boolean result = false;
          for (TrieNode node : children.values()) {
            if (start == word.length() - 1 && node.isWord) {
              return true;
            }
            if (dfsSearch(node.children, word, start+1)) {
              return true;
            }
          }
          return true;
        } else {
          return false;
        }
      }
    }

    public static void main (String[] args) {
      Trie trie = new Trie();
      trie.insert("manuel");
      trie.insert("margo");
      System.out.println(trie.search("Manuel"));
      trie.print();
      System.out.println(trie.searchPattern("*anuel"));

    }
  }
