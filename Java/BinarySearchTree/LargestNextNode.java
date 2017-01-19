import java.util.*;
import java.lang.*;
import java.io.*;
/*
Binary Search Tree Question.
Given a node in a binary search tree, return the largest next node.

          5
       /    \
      2      7
    /  \    /  \
   1   3   6   8

largestNext(2) = 3;
largestNext(5) = 6;
largestNext(1) = 1;
largestNext(7) = 8;
largestNext(3) = 5;

*/


class LargestNextNode {

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

  public static int largestNext(Node tree, Node n) {
    if (n == null) return -1;
    Node right = n.right;
    if (right != null) {
      return solve(right, n.data);
    } else {
      return parent(tree, n, n.data);
    }
  }

  private static int solve(Node n, int prev) {
    if ( n== null) return prev;
    return solve(n.left, n.data);
  }

  private static int parent(Node tree, Node n, int prev) {
    if (tree.data == n.data) return prev;
    if (tree.data > n.data) return parent(tree.left, n, tree.data);
    else return prev;
  }

  // BFS
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

  // DFS
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
    Node n7 = new Node(7);
    Node n8 = new Node(8);

    n5.left = n2;
    n5.right = n7;
    n2.left = n1;
    n2.right = n3;
    n7.left = n6;
    n7.right = n8;
    // printLevelOrder(n5);
    System.out.println("---");
    System.out.println(largestNext(n5, n5));
    System.out.println(largestNext(n5, n2));
    System.out.println(largestNext(n5, n1));
    System.out.println(largestNext(n5, n3));
  }
}
