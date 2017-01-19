import java.util.*;
import java.lang.*;
import java.io.*;
/*
21. Write a function that takes as input a pointer to the root of a binary tree,
then returns whether it's a valid binary search tree.

               1
            /     \
          2         3
        /   \    /    \
      4     5   6      7
      \        /  \  /   \
      8      9   10  11  12
            /
          13

*/

class IsBalanced {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  // public static boolean isBalanced(Node root) {
  //   if (balancedHeight(root) > -1 ) return true;
  //   else return false;
  // }
  //
  // private static int balancedHeight(Node n) {
  //   if (n == null) return 0;
  //   int left = balancedHeight(n.left);
  //   int right = balancedHeight(n.right);
  //
  //   if (left == -1 || right == -1) return -1;
  //   if (Math.abs(left - right) > 1) return -1;
  //   return Math.max(left+1, right+1);
  // }

  public static boolean isBalanced(Node root) {
    if (traverse(root) == -1) return false;
    else return true;
  }

  private static int traverse(Node n) {
    if (n == null) return 0;

    int left = traverse(n.left);
    int right = traverse(n.right);

    if (left == -1 || right == -1) return -1;
    if (Math.abs(left-right) > 1) return -1;
    if (left > right) return left+1;
    else return right+1;
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
    System.out.println(isBalanced(n4));
  }
}
