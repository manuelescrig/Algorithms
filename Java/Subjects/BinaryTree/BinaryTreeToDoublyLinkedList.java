import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a Tree, write a function to convert it into a Circular Doubly Linked List
from left to right only modifiying the existing pointers.

            1
          /   \
         2      3
       /  \   /  \
      4   5  6   7

   <- 4 <-> 2 <-> 5 <-> 1 <-> 6 <-> 3 <-> 7 ->
*/

class BinaryTreeToDoublyLinkedList {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static Node treeToList(Node n) {
    if (n == null) return null;

    Node left = treeToList(n.left);
    Node right = treeToList(n.right);
    n.left = n;
    n.right = n;
    n = concatenate(left,n);
    n = concatenate(right,n);
    return n;
  }

  private static Node concatenate(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;
    Node aEnd = a.left;
    Node bEnd = b.left;
    a.left = bEnd;
    bEnd.right = a;
    aEnd.right = b;
    b.left =  aEnd;
    return a;
  }

  // InOrder
  public static void printInOrder(Node n) {
    if (n == null) return;

    printInOrder(n.left);
    System.out.print(n.data + " ");
    printInOrder(n.right);
  }

  // PreOrder Recursive
  public static void printDFS(Node n) {
    if (n == null) return;

    System.out.print(n.data + " ");
    printDFS(n.left);
    printDFS(n.right);
  }

  // PreOrder Iterative
  public static void printPreOrder(Node n) {
    Stack<Node> stack = new Stack<Node>();
    stack.push(n);

    while (!stack.isEmpty()) {
      Node temp = stack.pop();
      if (temp == null) continue;
      System.out.print(temp.data + " ");

      stack.push(temp.right);
      stack.push(temp.left);
    }
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    printInOrder(n1);
    System.out.println(" ");
    printDFS(n1);
    System.out.println(" ");
    printPreOrder(n1);
    System.out.println(" ");
  }
}
