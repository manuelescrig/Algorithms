import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a binary tree, a target node in the binary tree, and an integer value k,
print all the nodes that are at distance k from the given target node.
No parent pointers are available.

Consider the tree

          5
       /    \
      2      7
    /  \    /  \
   1   3   6   8

set = {1,2,3,5,6,7,8}
map = {5,null} {2,5} {1,2} {3,2} {7,5} {6,7} {8,7}

Input:
root = 5
target = 8
k = 2
Output : 5,6
8,7->7,5
6,7->7,5
paths = {8,7} {8,7,6} {8,7,5} {8,7,5,2} {8,7,5,2,1} {8,7,5,2,3}

Input:
root = 5
target = 1
k = 4
Output : 6,8
1->2->5
6->7
8->7
paths = {1,2} {1,2,3} {1,2,5} {1,2,5,7} {1,2,5,7,6} {1,2,5,7,8}
*/

class KDistanceNodes {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static void printDistanceK(Node tree, Node target, int k) {
    HashSet<Node> set = new HashSet<Node>();
    preOrder(tree, set);
    set.remove(target);
    ArrayList<Stack<Node>> paths = new ArrayList<Stack<Node>>();
    for (Node node : set) {
      paths.add(pathFromTo(tree,target,node));
    }
    for (Stack<Node> list : paths) {
      if (list.size() == k+1) {
        Node n = list.pop();
        System.out.println(n.data);
      }
    }
  }

  private static Stack<Node> pathFromTo(Node root, Node a, Node b) {
    if (root == null || a == null || b == null) return null;
    Stack<Node> result = new Stack<Node>();
    if (a == b) {
      result.add(a);
      return result;
    }
    Stack<Node> pathA = path(root, a);
    Stack<Node> pathB = path(root, b);
    if (pathA == null || pathB == null) return null;

    // for (Node n : pathA) {
    //   System.out.print("" + n.data + " ");
    // } System.out.println("<-pathA");

    // for (Node n : pathB) {
    //   System.out.print("" + n.data + " ");
    // } System.out.println("<-pathB");

    Node prev = root;
    while (!pathA.isEmpty() && !pathB.isEmpty()) {
      Node tempA = pathA.pop();
      Node tempB = pathB.pop();
      if (tempA == tempB) prev = tempA;
      else {
        result.push(prev);
        result.push(tempA);
        result.push(tempB);
      break;
      }
    }
    if (result.isEmpty()) result.push(prev);
    while (!pathA.isEmpty()) result.push(pathA.pop());
    while (!pathB.isEmpty()) result.push(pathB.pop());

    return result;
  }

  private static Stack<Node> path(Node tree, Node target) {
    if (tree == null) return null;
    if (tree == target) {
      Stack<Node> stack = new Stack<Node>();
      stack.push(tree);
      return stack;
    }
    Stack<Node> left = path(tree.left, target);
    Stack<Node> right = path(tree.right, target);
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

  public static void preOrder(Node root, HashSet<Node> set) {
    if (root == null) return;
    set.add(root);
    preOrder(root.left, set);
    preOrder(root.right, set);
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
    printDistanceK(n5,n1,2);

  }
}
