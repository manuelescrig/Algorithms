import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a function to print spiral order traversal of a tree.
For below tree, function should print 1, 2, 3, 4, 5, 6, 7.


               1
            /     \
          2         3
        /   \    /    \
      7     6   5      4


*/

class BinaryTreePrintSpiralForm {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  // Ccomplexity: O(n) time and O(n) extra space.
  public static void printSpiral(Node root) {
    if (root == null) return;
    Stack<Node> stackA = new Stack<Node>();
    Stack<Node> stackB = new Stack<Node>();
    stackA.add(root);

    while (!stackA.isEmpty() || !stackB.isEmpty()) {

      while (!stackA.isEmpty()) {
        Node temp = stackA.pop();
        System.out.print(temp.data + " ");
        if (temp.right != null) stackB.push(temp.right);
        if (temp.left != null) stackB.push(temp.left);
      }

      while (!stackB.isEmpty()) {
        Node temp = stackB.pop();
        System.out.print(temp.data + " ");
        if (temp.left != null) stackA.push(temp.left);
        if (temp.right != null) stackA.push(temp.right);
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
    Node n9 = new Node(9);

    n1.right = n3;
    n1.left = n2;
    n3.right = n4;
    n3.left = n5;
    n2.right = n6;
    n2.left = n7;
    printSpiral(n1);
    System.out.println("-");
  }
}
