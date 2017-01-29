import java.util.*;
import java.lang.*;
import java.io.*;

/**
Given a binary tree find the size of largest independent set (LIS).
This means that no two nodes in final set have direct parent-child
relationship with each other.


               a1
              /  \
            a2   a3
           / \    \
          a4  a5  a8
              / \
             a6 a7
Result = a1,a4,a6,a7;
LIS->5 because the set would be a1,a6,a4,a8,a7

 a1
  \
   a2
    \
     a3
      \
       a4
        \
         a5
Result = a1,a3,a5;

      a1
      /\
     a2 a3
 Result = a2,a3;
*/

class BinaryTreeBinaryTreeLIS {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static int lis(Node n) {
    HashSet<Node> set = new HashSet<Node>();
    solve(n, set);
    return set.size();
  }

  public static void solve(Node n, HashSet<Node> set) {
    if (n == null) return;
    solve(n.left, set);
    solve(n.right, set);

    if (n.left == null && n.right == null) {
      set.add(n);
    } else if (n.left != null) {
      if (!set.contains(n.left)) set.add(n);
    } else if (n.right != null) {
      if (!set.contains(n.right)) set.add(n);
    } else {
      if (!set.contains(n.left) && !set.contains(n.right)) set.add(n);
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

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n5.left = n6;
    n5.right = n7;
    n3.right = n8;
    System.out.println(lis(n1));
  }
}
