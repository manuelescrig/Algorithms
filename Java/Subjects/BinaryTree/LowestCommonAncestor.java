import java.util.*;
import java.lang.*;
import java.io.*;

/*
*/

class LowestCommonAncestor {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static Node lca(Node tree, Node a, Node b) {
    if (a.equals(b)) return a;
    Stack<Node> pathA = pathTo(tree,a);
    Stack<Node> pathB = pathTo(tree,b);
    if (pathB == null || pathA == null) return null;
    Node prev = tree;
    while (!pathA.isEmpty() && !pathB.isEmpty()) {
      Node tempA = pathA.pop();
      Node tempB = pathB.pop();
      if (tempA.equals(tempB)) prev = tempA;
      else break;
    }
    return prev;
  }

  public static Stack<Node> pathTo(Node tree, Node n) {
    if (tree == null) return null;
    if (tree.equals(n)) {
      Stack<Node> s = new Stack<Node>();
      s.push(tree);
      return s;
    }
    Stack<Node> left = pathTo(tree.left, n);
    Stack<Node> right = pathTo(tree.right, n);
    if (left != null) {
      left.push(tree);
      return left;
    }
    if (right != null) {
      right.push(tree);
      return right;
    }
    return null;
  }


  public static void levelOrder(Node n) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(n);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      System.out.print(temp.data + " ");

      if (temp.left != null){
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

  // public static void preOrder(Node n) {
  //   if (n == null) return;
  //   System.out.print(n.data + " ");
  //   preOrder(n.left);
  //   preOrder(n.right);
  // }

  public static void preOrder(Node n) {
    Stack<Node> stack = new Stack<Node>();
    stack.push(n);

    while (!stack.isEmpty()) {
      Node temp = stack.pop();
      System.out.print(temp .data + " ");

      if (temp.right != null)
        stack.push(temp.right);
      if (temp.left != null)
        stack.push(temp.left);
    }
  }

  public static void inOrder(Node n) {
    if (n == null) return;
    inOrder(n.left);
    System.out.print(n.data + " ");
    inOrder(n.right);
  }

  public static void postOrder(Node n) {
    if (n == null) return;
    postOrder(n.right);
    postOrder(n.left);
    System.out.print(n.data + " ");
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
    Node result = lca(n1,n4,n3);
    System.out.println(result.data);
    System.out.println("---");

    levelOrder(n1);
    System.out.println("---");

    preOrder(n1);
    System.out.println("---");

    inOrder(n1);
    System.out.println("---");

    postOrder(n1);
    System.out.println("---");
  }
}
