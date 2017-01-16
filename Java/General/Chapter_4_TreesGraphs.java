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
  2.InOrder Recursive Traversal
  */
  public static void inOrderRecursive(TreeNode n) {
    if (n == null) return;

    inOrderRecursive(n.left);
    System.out.println(n.data);
    inOrderRecursive(n.right);
  }


  // public static List<Integer> inorderIterative(TreeNode root) {
  //     List<Integer> list = new ArrayList<Integer>();
  //
  //     Stack<TreeNode> stack = new Stack<TreeNode>();
  //     TreeNode cur = root;
  //
  //     while(cur!=null || !stack.empty()){
  //         while(cur!=null){
  //             stack.add(cur);
  //             cur = cur.left;
  //         }
  //         cur = stack.pop();
  //         list.add(cur.val);
  //         cur = cur.right;
  //     }
  //
  //     return list;
  // }

  /*
  2.PreOrder Recursive Traversal
  */
  public static void preOrderRecursive(TreeNode n) {
    if (n == null) return;

    System.out.println(n.data);
    preOrderRecursive(n.left);
    preOrderRecursive(n.right);
  }

  /*
  2.PostOrder Recursive Traversal
  */
  public static void postOrderRecursive(TreeNode n) {
    if (n == null) return;

    postOrderRecursive(n.left);
    postOrderRecursive(n.right);
    System.out.println(n.data);
  }


  /*
  3.Level Order BFS Iterative
  */
  public static void bfsIterative(TreeNode n) {
    if (n == null) return;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(n);

    while (!queue.isEmpty()) {
      TreeNode temp = queue.remove();

      System.out.println(temp.data);
      if (temp.left != null) queue.add(temp.left);
      if (temp.right != null) queue.add(temp.right);
    }

  }

  /*
  3.DFS Iterative
  */
  public static void dfsIterative(TreeNode n) {

  }



  /*
            4
          /   \
         2     6
        / \   / \
       1  3  5  7
                 \
                  8

  */
  public static void main (String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;

    System.out.println("2.InOrder Recursive");
    inOrderRecursive(n4);
    System.out.println("-");

    System.out.println("2.PreOrder Recursive");
    preOrderRecursive(n4);
    System.out.println("-");

    System.out.println("2.PostOrder Recursive");
    postOrderRecursive(n4);
    System.out.println("-");

    System.out.println("3.Level Order BFS Iterative ");
    bfsIterative(n4);
    System.out.println("-");

  }
}
