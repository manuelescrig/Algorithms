import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given A binary Tree, how do you remove all the half nodes
(which has only one child)? Note leaves should not be touched as they
have both children as NULL.

Imput:
               2
            /     \
           7       5
           \        \
            6        9
          /  \      /
         1   3     4

Output:
          2
       /     \
      6       4
    /  \
   1   3
*/

class BinaryTreeRemoveHalfNodes {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  // Time complexity O(n) as it does a simple traversal of binary tree.
  public static void removeHalfNodes(Node root) {
    if (root == null) return;

    root.left = recurse(root.left);
    root.right = recurse(root.right);
  }

  public static Node recurse(Node root) {
    if (root == null) return null;

    if (root.left == null && root.right == null) return root;
    if (root.left == null) return recurse(root.right);
    if (root.right == null) return recurse(root.left);
    return root;
  }

  public static void print(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    print(root.left);
    print(root.right);
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

    n2.left = n7;
    n7.right = n6;
    n6.left = n1;
    n6.right = n3;
    n2.right = n5;
    n5.right = n9;
    n9.left = n4;

    print(n2);
    System.out.println("");
    removeHalfNodes(n2);
    print(n2);
    System.out.println("");
  }
}
