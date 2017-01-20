import java.util.*;
import java.lang.*;
import java.io.*;

/*
Find Root Of node.
*/

class FindRootOf {

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

  public static boolean insert(Node n, int k) {

    while (n != null) {
      if (n.data == k) return false;
      if (n.data > k) {
        if (n.left != null) {
          n = n.left;
        } else {
          n.left = new Node(k);
          return true;
        }
      } else {
        if (n.right != null) {
          n = n.right;
        } else {
          n.right = new Node(k);
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isPresent(Node n, int k) {
    if (n == null) return false;

    while (n != null) {
      if (n.data == k) return true;
      if (n.data > k) {
        n = n.left;
      } else {
        n = n.right;
      }
    }
    return false;
  }

  public static Node findRootOf(Node n, int k) {
      Node prev = null;
      while (n != null) {
        if (n.data == k) return prev;
        prev = n;
        if (n.data > k) {
          n = n.left;
        } else {
          n = n.right;
        }
      }
      return null;
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
    System.out.println(isPresent(n4,7));

    System.out.println("---");
    System.out.println(insert(n4,7));

    System.out.println("---");
    System.out.println(isPresent(n4,7));

    System.out.println("---");
    Node result = findRootOf(n4, 2);
    System.out.println(result.data);
  }
}
