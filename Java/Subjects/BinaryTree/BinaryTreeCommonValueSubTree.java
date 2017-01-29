import java.util.*;
import java.lang.*;
import java.io.*;

/*
Common Value Subtree
In a binary tree, a common value subtree is a complete subtree
(that is, either the empty tree or a node and all its descendants)
where every node has the same value. Given a binary tree, return a pointer
to the largest common value subtree in that tree.
*/

class BinaryTreeCommonValueSubTree {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  // pre-order traversal
  public static Node commonValueSubtree(Node root) {
    Node result = null;
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    int max = Integer.MIN_VALUE;
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      int sum = countSubtree(node, node.data);
      if ( sum > max) {
        max = sum;
        result = node;
        System.out.println(max);
      }

      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    return result;
  }

  public static int countSubtree(Node root, int k) {
    if (root.data != k) return 0;
    int total = 1;
    if (root.left != null)  total += countSubtree(root.left,k);
    if (root.right != null) total += countSubtree(root.right,k);
    return total;
  }

  public static void main (String[] args) {
    Node n1 = new Node(3);
    Node n2 = new Node(3);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(6);
    Node n6 = new Node(6);
    Node n7 = new Node(6);
    Node n8 = new Node(6);

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    commonValueSubtree(n4);
  }
}
