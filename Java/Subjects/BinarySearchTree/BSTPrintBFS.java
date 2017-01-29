import java.util.*;
import java.lang.*;
import java.io.*;

/*
*/

class BSTPrintBFS {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // BFS (Level Order)
  public static void printLevelOrder(Node n) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(n);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      if (temp == null) return;
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

    n4.left = n2;
    n4.right = n5;
    n2.left = n1;
    n2.right = n3;
    n5.right = n6;

    System.out.println("---");
    printLevelOrder(n4);
  }
}
