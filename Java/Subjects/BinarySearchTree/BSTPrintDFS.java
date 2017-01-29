import java.util.*;
import java.lang.*;
import java.io.*;

/*
*/

class BSTPrintDFS {

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

  // DFS (Pre Order)
  public static void printPreOrder(Node n) {
    Stack<Node> stack = new Stack<Node>();
    stack.push(n);

    while (!stack.isEmpty()) {
      Node temp = stack.pop();
      if (temp == null) continue;
      System.out.println(temp.data);

      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
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
    printPreOrder(n4);
  }
}
