import java.util.*;
import java.lang.*;
import java.io.*;

/*
Top view of a binary tree is the set of nodes visible when the tree is
viewed from the top. Given a binary tree, print the top view of it.
The output nodes can be printed in any order.
Expected time complexity is O(n)
       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6


               4
            /     \
          2         6
        /   \    /    \
      1     3   5      7
                        \
                          8
                          \
                          9



*/

class BinaryTreePrintTopView {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static void printTopView(Node root) {
    if (root == null) return;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    map.put(0, root);
    traverse(root.left, map, -1);
    traverse(root.right, map, +1);

    for (Node n : map.values()) {
      System.out.print(n.data + " ");
    }
  }

  public static void traverse(Node root, HashMap<Integer, Node> map, int distance) {
    if (root == null) return;
    if (!map.containsKey(distance)) {
      map.put(distance,root);
    }
    traverse(root.left, map, distance-1);
    traverse(root.right, map, distance+1);
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    n8.right = n9;
    printTopView(n4);
    System.out.println("-");
  }
}
