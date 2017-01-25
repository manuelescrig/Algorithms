import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a Binary Tree where each node has positive and negative values.
Convert this to a tree where each node contains the sum of the left and right
sub trees in the original tree. The values of leaf nodes are changed to 0.


               10
            /     \
          -2        6
        /   \    /    \
      8    -4   7     5

              20(4-2+12+6)
           /     \
        4 (8-4)   12(7+5)
       /   \    /    \
      0    0   0     0

            30
         /     \
       2       12
     /   \    /    \
    8    -4  7     5



*/

class BinaryTreeSumTree {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static int sumTree(Node root) {
    if (root == null) return 0;

    int temp = root.data;
    root.data = sumTree(root.left) + sumTree(root.right);
    return temp + root.data;
  }

  public static void print(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    print(root.left);
    print(root.right);
  }


  public static void main (String[] args) {
    Node n1 = new Node(10);
    Node n2 = new Node(-2);
    Node n3 = new Node(6);
    Node n4 = new Node(8);
    Node n5 = new Node(-4);
    Node n6 = new Node(7);
    Node n7 = new Node(5);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    print(n1);
    System.out.println("");
    sumTree(n1);
    print(n1);
    System.out.println("");
  }
}
