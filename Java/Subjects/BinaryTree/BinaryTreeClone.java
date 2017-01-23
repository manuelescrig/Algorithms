import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a function that clones the binary tree.

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

class BinaryTreeClone {

  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static Node cloneTree(Node root) {
    if (root == null) return null;

    Node newRoot = new Node(root.data);
    Queue<Node> queueA = new LinkedList<Node>();
    Queue<Node> queueB = new LinkedList<Node>();
    queueA.add(root);
    queueB.add(newRoot);

    while (!queueA.isEmpty()) {
      Node tempA = queueA.remove();
      Node tempB = queueB.remove();

      if (tempA.left != null) {
        Node newLeft = new Node(tempA.left.data);
        tempB.left = newLeft;
        queueA.add(tempA.left);
        queueB.add(newLeft);
      }
      if (tempA.right != null) {
        Node newRight = new Node(tempA.right.data);
        tempB.right = newRight;
        queueA.add(tempA.right);
        queueB.add(newRight);

      }
    }

    return newRoot;
  }

  public static void print(Node root) {
    if (root == null) return;

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      System.out.print(temp.data + " ");

      if (temp.left != null) queue.add(temp.left);
      if (temp.right != null) queue.add(temp.right);
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

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    n8.right = n9;
    print(n4);
    Node copy = cloneTree(n4);
    System.out.println("-");
    print(copy);
  }
}
