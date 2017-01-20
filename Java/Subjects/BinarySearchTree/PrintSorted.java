import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a recursive function that,
given a pointer to the root of a binary search tree,
prints out the elements in that tree in sorted order.
*/

class PrintSorted {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  // level-order BFS
  public static void iterative(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.println(node.data);

      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
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
    iterative(n4);
  }
}
