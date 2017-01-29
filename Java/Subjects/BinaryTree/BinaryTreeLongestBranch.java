import java.util.*;
import java.lang.*;
import java.io.*;

/**
Given a binary tree find the length of the longest branch of nodes in
increasing consecutive order.

eg.
            0
          /   \
         1     2
       / \    / \
      1  2   1  3

length = 3;


 */

class BinaryTreeLongestBranch {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  private static int max(int... vals) {
    int max = Integer.MIN_VALUE;
    for (int x : vals) {
      if (x > max) max = x;
    }
    return max;
  }


  public static int consecutive(Node n) {
    if (n == null) return 0;
    return max(consecutive(n.left, 1, n.data),consecutive(n.right, 1, n.data));
  }

  private static int consecutive(Node n, int length, int prev) {
    if (n == null) return length;
    if (n.data == prev + 1) {
      int leftLength = consecutive(n.left, length+1, n.data);
      int rightLength = consecutive(n.right, length+1, n.data);
      return max(leftLength,rightLength);
    } else {
      int leftLength = consecutive(n.left,1, n.data);
      int rightLength = consecutive(n.right,1, n.data);
      return max(leftLength,rightLength, length);
    }
  }

  public static void main (String[] args) {
    Node n1 = new Node(0);
    Node n2 = new Node(1);
    Node n3 = new Node(2);
    Node n4 = new Node(1);
    Node n5 = new Node(2);
    Node n6 = new Node(1);
    Node n7 = new Node(3);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    System.out.println("---");
    System.out.println(consecutive(n1));
  }
}
