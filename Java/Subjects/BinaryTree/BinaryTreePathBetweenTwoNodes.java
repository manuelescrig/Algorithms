import java.util.*;
import java.lang.*;
import java.io.*;

/*
Find Path Between Two Nodes in a Binary Tree
(need not be BST or balanced).

          5
       /    \
      2      7
    /  \    /  \
   1   3   6   8

path(3,6) = 3,2,5,7,6
path(8,6) = 8,7,6
*/

class BinaryTreePathBetweenTwoNodes {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }
  // Iterative with BFS and HashMap
  public static List<Node> path(Node root, Node a, Node b) {
    HashMap<Node,Node> map = new HashMap<Node,Node>();
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    map.put(root,null);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      if (temp.left != null) {
        map.put(temp.left,temp);
        queue.add(temp.left);
      }
      if (temp.right != null) {
        map.put(temp.right,temp);
        queue.add(temp.right);
      }
    }

    List<Node> result = new ArrayList<Node>();
    int index = 0;
    result.add(b);
    result.add(index,a);

    Node tempA = a;
    Node tempB = b;

    while (tempA != null && tempB != null) {
      index++;
      tempA = map.get(tempA);
      tempB = map.get(tempB);

      if (tempA == tempB) {
        result.add(index, tempA);
        break;
      } else {
        result.add(index,tempB);
        result.add(index,tempA);
      }
    }

    return result;
  }

  // Recursive
  public static boolean printPath(ArrayList<Node> path, Node root, Node dest) {
		if( root == null ) return false;
		if( root == dest || printPath(path, root.left,dest) || printPath(path, root.right,dest)) {
			// System.out.print("  " + root.data);
			path.add(root);
			return true;
		}
		return false;
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
    n7.left = n6;
    n7.right = n8;
    levelOrder(n5);
    System.out.println("--");
    List<Node> result = path(n5, n8, n6);
    for (Node n : result) {
      System.out.print(n.data + " ");
    }
  }
}
