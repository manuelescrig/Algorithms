import java.util.*;
import java.lang.*;
import java.io.*;

/*
Print level order

          5
       /  |  \
      2   |   7
    /  \  |  /  \
   1   3  | 6   8
true

           5
        /    \
       2      7
     /  \   /  \
    1   3  4   8
false
*/

class PrintLevelOrder {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static boolean isBinarySearchTree(Node root) {
    if (root == null) return true;
    return isBST(root.left, Integer.MIN_VALUE, root.data) &&
           isBST(root.right, root.data, Integer.MAX_VALUE);
  }

  public static boolean isBST(Node n, int min, int max) {
    if (n == null) return true;
    System.out.println(n.data + "," + min + "," + max);
    if (n.data > max || n.data < min) return false;
    return isBST(n.left, min, n.data) &&
           isBST(n.right, n.data + 1, max);
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
    // n7.left = n6;
    n7.left = n4;
    n7.right = n8;
    // levelOrder(n5);
    System.out.println(isBinarySearchTree(n5));
  }
}
