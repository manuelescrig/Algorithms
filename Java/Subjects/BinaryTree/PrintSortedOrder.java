import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a recursive function that,
given a pointer to the root of a binary search tree,
prints out the elements in that tree in sorted order.
*/

class PrintSortedOrder {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  // in-order traversal
  public static void recursionSorted(Node root) {

    if (root.left != null) recursionSorted(root.left);
    System.out.println(root.data);
    if (root.right != null) recursionSorted(root.right);

    return;
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

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    recursionSorted(n4);
  }
}
