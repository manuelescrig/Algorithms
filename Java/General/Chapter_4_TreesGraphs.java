import java.util.*;
import java.lang.*;
import java.io.*;
/*
Questions
­1.Check if tree is balanced
­2.All traversals, recursive and iterative implementations
­3.BFS/DFS
­4.Construct a BST from a sorted array
­5.Check if two trees are mirror image of each other
­6.Find max path sum in the tree, negative nodes possible
­7.Lowest common ancestor of 2 nodes in a tree

          4
        /   \
       2     6
      / \   / \
     1  3  5  7
               \
                8

*/

class Chapter_4_TreesGraphs {

  public static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int e) {
      this.data = e;
    }
  }

  /*
  ­1.Check if tree is balanced
  */
  public static boolean isBalanced(TreeNode root) {
    if (depth(root) != -1) return true;
    else return false;
  }

  public static int depth(TreeNode root) {
    if (root == null) return 0;

    int left = depth(root.left);
    int right = depth(root.right);
    if (Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left,right);
  }

  /*
  2.InOrder Recursive
  [1, 2, 3, 4, 5, 6, 7, 8]
  */
  public static void inOrderRecursive(TreeNode n) {
    if (n == null) return;

    inOrderRecursive(n.left);
    System.out.print(n.data + " ");
    inOrderRecursive(n.right);
  }

  /*
  2.InOrder Iterative
  [1, 2, 3, 4, 5, 6, 7, 8]
  */
  public static ArrayList<Integer> inOrderIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      //System.out.print(curr.data + " ");
      list.add(curr.data);
      curr = curr.right;
    }
    return list;
  }

  /*
  2.PreOrder DFS Recursive
  [4, 2, 1, 3, 6, 5, 7, 8]
  -
  */
  public static void preOrderRecursive(TreeNode n) {
    if (n == null) return;

    System.out.print(n.data + " ");
    preOrderRecursive(n.left);
    preOrderRecursive(n.right);
  }

  /*
  2.PreOrder DFS Iterative
  [4, 2, 1, 3, 6, 5, 7, 8]
  */
  public static List<Integer> dfsIterative(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while(!stack.isEmpty() && root != null) {
      TreeNode temp = stack.pop();
      // System.out.print(temp.data + " ");
      list.add(temp.data);
      if (temp.right != null) stack.push(temp.right);
      if (temp.left != null) stack.push(temp.left);
    }
    return list;
  }


  /*
  2.PostOrder Recursive
  [1, 3, 2, 5, 8, 7, 6, 4]
  */
  public static void postOrderRecursive(TreeNode n) {
    if (n == null) return;

    postOrderRecursive(n.left);
    postOrderRecursive(n.right);
    System.out.print(n.data + " ");
  }

  /*
  2.PostOrder Iterative
  [1, 3, 2, 5, 8, 7, 6, 4]
  */
  public static List<Integer> postOrderIterative(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (!stack.isEmpty() && root != null) {
      TreeNode curr = stack.pop();
      list.add(0,curr.data);
      if (curr.left != null) stack.push(curr.left);
      if (curr.right != null) stack.push(curr.right);
    }

    return list;
  }


  /*
  3.LevelOrder BFS Iterative
  [4, 2, 6, 1, 3, 5, 7, 8]
  */
  public static List<Integer> bfsIterative(TreeNode n) {
    if (n == null) return null;
    ArrayList<Integer> list = new ArrayList<Integer>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(n);
    while (!queue.isEmpty()) {
      TreeNode temp = queue.remove();
      // System.out.print(temp.data + " ");
      list.add(temp.data);
      if (temp.left != null) queue.add(temp.left);
      if (temp.right != null) queue.add(temp.right);
    }
    return list;
  }



  public static void main (String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);
    TreeNode n9 = new TreeNode(9);

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    n8.right = n9;

    System.out.println("1.Check if tree is balanced");
    System.out.println(isBalanced(n4));
    System.out.println("-");

    System.out.println("2.InOrder Recursive");
    inOrderRecursive(n4);
    System.out.println("-");

    System.out.println("2.InOrder Iterative");
    List<Integer> inOrder = inOrderIterative(n4);
    System.out.println(inOrder.toString());
    System.out.println("-");

    System.out.println("2.PreOrder Recursive");
    preOrderRecursive(n4);
    System.out.println("-");

    System.out.println("2.PostOrder Recursive");
    postOrderRecursive(n4);
    System.out.println("-");

    System.out.println("2.PostOrder Iterative");
    List<Integer> postOrder = postOrderIterative(n4);
    System.out.println(postOrder.toString());
    System.out.println("-");

    System.out.println("3.LevelOrder BFS Iterative");
    List<Integer> levelOrder = bfsIterative(n4);
    System.out.println(levelOrder.toString());
    System.out.println("-");

    System.out.println("3.PreOrder DFS Iterative");
    List<Integer> preOrder = dfsIterative(n4);
    System.out.println(preOrder.toString());
    System.out.println("-");


  }
}
