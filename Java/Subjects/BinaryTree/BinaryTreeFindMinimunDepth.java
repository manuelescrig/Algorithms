import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a binary tree, find its minimum depth. The minimum depth is the number of
nodes along the shortest path from root node down to the nearest leaf node.


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

class BinaryTreeFindMinimunDepth {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  // Time complexity O(n) n = number of nodes
  public static int findMinimumDepth(Node root) {
    if (root == null) return 0;
    System.out.println(root.data);
    int left = findMinimumDepth(root.left) + 1;
    int right = findMinimumDepth(root.right) + 1;
    return Math.min(left,right);
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
    System.out.println(findMinimumDepth(n4));
    System.out.println("-");
  }
}
