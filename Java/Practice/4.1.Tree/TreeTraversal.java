import java.util.*;
import java.lang.*;
import java.io.*;

/*
Binary Tree Traversal: Preorder, Inorder, Postorder, Level Order, Vertical Order

                 1
              /    \
             2      3
           /  \   /  \
          4   5  6   7
                /
               8
*/

class TreeTraversal {

  public static class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
      this.value = value;
    }
  }

  public static void preOrder(Node root) {
    if (root == null) return;
    System.out.print(root.value + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void inOrder(Node root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.print(root.value + " ");
    inOrder(root.right);
  }

  public static void postOrder(Node root) {
    if (root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.value + " ");
  }

  public static void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      System.out.print(temp.value + " ");

      if (temp.left != null) queue.add(temp.left);
      if (temp.right != null) queue.add(temp.right);
    }
  }

  public static ArrayList<ArrayList<Integer>> levelOrderGrouped(Node root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> values = new ArrayList<Integer>();
    if (root == null) return result;
    Queue<Node> current = new LinkedList<Node>();
    Queue<Node> next = new LinkedList<Node>();
    current.add(root);
    while (!current.isEmpty()) {
      Node temp = current.remove();

      if (temp.left != null) next.add(temp.left);
      if (temp.right != null) next.add(temp.right);
      values.add(temp.value);
      if (current.isEmpty()) {
        current = next;
        next = new LinkedList<Node>();
        result.add(values);
        values = new ArrayList<Integer>();
      }
    }
    return result;
  }

  public static ArrayList<ArrayList<Integer>> verticalOrderGrouped(Node root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) return result;
    // Level and values
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
    int min = 0;
    int max = 0;

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);

    Queue<Integer> levels = new LinkedList<Integer>();
    levels.add(0);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      Integer level = levels.remove();
      min = Math.min(min, level);
      max = Math.max(max, level);

      if (map.containsKey(level)) {
        ArrayList<Integer> values = map.get(level);
        values.add(temp.value);
        map.put(level,values);
      } else {
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(temp.value);
        map.put(level,values);
      }

      if (temp.left != null) {
        queue.add(temp.left);
        levels.add(level - 1);
      }

      if (temp.right != null) {
        queue.add(temp.right);
        levels.add(level + 1);
      }
    }
    for (int i = min; i <= max; i++) {
      result.add(map.get(i));
    }

    return result;
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
    n6.left = n8;
    preOrder(n1);
    System.out.println(" ");
    inOrder(n1);
    System.out.println(" ");
    postOrder(n1);
    System.out.println(" ");
    levelOrder(n1);
    System.out.println(" ");
    ArrayList<ArrayList<Integer>> result = levelOrderGrouped(n1);
    System.out.print(result.toString());
    System.out.println(" ");
    ArrayList<ArrayList<Integer>> verticalResult = verticalOrderGrouped(n1);
    System.out.print(verticalResult.toString());

  }
}
