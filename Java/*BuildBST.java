import java.util.*;
import java.lang.*;
import java.io.*;
/*
24. Write a function that, given a sorted array,
builds a balanced binary search tree with the same values.
*/

class BuildBST {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static void buildBST(int[] array) {
    Node root = new Node(array[0]);
    for (int i=1; i<array.length; i++) {
      root = insertValue(root,array[i]);
      balance(root);
    }
    print(root);
  }

  public static Node insertValue(Node root, int value) {
    if (value > root.data) {
      // Insert Right
      if (root.right == null) {
        Node node = new Node(value);
        root.right = node;
        return root;
      } else {
        insertValue(root.right, value);
      }

    } else {
      // Insert Left
      if (root.left == null) {
        Node node = new Node(value);
        root.left = node;
        return root;
      } else {
        insertValue(root.left, value);
      }
    }
    return root;
  }

  public static void balance(Node root) {
    //TODO:
  }

  public static void print(Node root) {

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.println(node.data);

      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }

    return;
  }
  public static void main (String[] args) {
    int[] array = {1,2,3,4,5,6,7,8};
    buildBST(array);
  }
}
