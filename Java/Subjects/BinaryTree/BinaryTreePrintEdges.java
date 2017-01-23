import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a function that prints the edges of the binary tree.

               4
            /     \
          2         6
        /   \    /    \
      1     3   5      7
                        \
                          8
                          \
                          9

          1

*/

class BinaryTreePrintEdges {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static void printEdges(Node root) {
    if (root == null) return;
    System.out.println(root.data);
    recurseLeftEdges(root.left);
    recurseRightEdges(root.right);
    recurseBottomEdges(root);
  }

  public static void recurseLeftEdges(Node root) {
    if (root == null) return;
    if (root.left != null) {
      System.out.println(root.data);
    }
    recurseLeftEdges(root.left);
  }

  public static void recurseRightEdges(Node root) {
    if (root == null) return;
    if (root.right != null) {
      System.out.println(root.data);
    }
    recurseRightEdges(root.right);
  }

  public static void recurseBottomEdges(Node root) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      System.out.println(root.data);
    }
    recurseBottomEdges(root.left);
    recurseBottomEdges(root.right);
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
    printEdges(n4);
    System.out.println("-");
  }
}
