import java.util.*;
import java.lang.*;
import java.io.*;

/*
Binary Tree Invert.

                 1                  1
              /    \             /    \
             2      3           3      2
           /  \   /  \        /  \   /  \
          4   5  6   7       7   6  5   4
                /                 \
               8                  8
*/

class TreeInvert {

  public static class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
      this.value = value;
    }
  }

  public static void invert(Node root) {
    if (root != null) traverse(root); 
  }

  public static void traverse(Node root) {

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    if (root.left != null) {
      traverse(root.left);
    }
    if (root.right != null) {
      traverse(root.right);
    }
  }

  public static void preOrder(Node root) {
    if (root == null) return;
    System.out.print(root.value + " ");
    preOrder(root.left);
    preOrder(root.right);
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
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    n6.left = n8;

    preOrder(n1);
    invert(n1);
    System.out.println("");
    preOrder(n1);
  }
}
