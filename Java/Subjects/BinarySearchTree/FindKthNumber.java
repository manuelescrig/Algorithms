import java.util.*;
import java.lang.*;
import java.io.*;
/*
You are given a binary search tree and a positive integer K.
Return the K-th element of the tree.
*/

class FindKthNumber {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  // BFS Level-order
  public static Node find(Node root, int k) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      k--;
      if (k == 0) return temp;

      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    return root;
  }

  public static void print(Node root) {

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      System.out.println(temp.data);
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
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
    Node n8 = new Node(8);

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    //System.out.println(findElement(n4,3));

    print(n4);
    System.out.println("--");
    Node temp = find(n4, 2);
    print(temp);
  }
}
