import java.util.*;
import java.lang.*;
import java.io.*;
/*

*/

class BinarySearchTreeLCA {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static Node lowestCommonAncestor(Node root,int v1,int v2) {
    // Smaller than both
    if (root.data < v1 && root.data < v2) {
      return lowestCommonAncestor(root.right,v1,v2);
    }
    // Bigger than both
    if (root.data > v1 && root.data > v2) {
      return lowestCommonAncestor(root.left,v1,v2);
    }
    // Else solution already found
    return root;
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
    Node solution = lowestCommonAncestor(n4, n8.data, n5.data);
    System.out.println(solution.data);
  }
}
