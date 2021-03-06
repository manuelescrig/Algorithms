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

          4               4
        /   \           /  \
       2     6         6    2
      / \   / \      /  \  / \
     1  3  5  7     7   5 3  1
               \   /
                8 8

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

  /*
  3.LevelOrder BFS Iterative Print
  [4, 2, 6, 1, 3, 5, 7, 8]
  */
  public static void levelOrder(TreeNode node) {
    if (node == null) return;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(node);
    while(!queue.isEmpty()) {
      TreeNode temp = queue.remove();
      System.out.print(temp.data + " ");
      if (temp.left != null) queue.add(temp.left);
      if (temp.right != null) queue.add(temp.right);
    }
  }

  /*
  4.Construct a BST from a sorted array Time Complexity: O(n)
  {1,2,3}
  */
  public static TreeNode constructBST(int[] array, TreeNode node) {
    if (array == null || array.length <= 0) return null;

    int mid = (0 + array.length) / 2;
    // System.out.println(array[mid]);
    node = new TreeNode(array[mid]);
    int[] left = Arrays.copyOfRange(array, 0, mid);
    node.left = constructBST(left, node.left);
    int[] right = Arrays.copyOfRange(array, mid+1, array.length);
    node.right = constructBST(right, node.right);
    return node;
  }

  /*
  ­5.Check if two trees are mirror image of each other
  Time Complexity : O(n)
  */
  public static boolean areMirror(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    Stack<TreeNode> stackA = new Stack<TreeNode>();
    stackA.push(a);
    Stack<TreeNode> stackB = new Stack<TreeNode>();
    stackB.push(b);

    while (!stackA.isEmpty() && !stackB.isEmpty()) {
      TreeNode tempA = stackA.pop();
      // System.out.println("A: " + tempA.data);
      TreeNode tempB = stackB.pop();
      // System.out.println("B: " + tempB.data);
      if (tempA.data != tempB.data) return false;

      if (tempA.right == null && tempB.left != null) return false;
      if (tempA.left == null && tempB.right != null) return false;

      if (tempA.right != null) stackA.push(tempA.right);
      if (tempA.left != null) stackA.push(tempA.left);
      if (tempB.left != null) stackB.push(tempB.left);
      if (tempB.right != null) stackB.push(tempB.right);
    }

    if (stackA.isEmpty() && stackB.isEmpty()) return true;
    else return false;
  }

  // Time Complexity : O(n)
  public static boolean areMirrorRecursive(TreeNode a, TreeNode b)  {
    /* Base case : Both empty */
    if (a == null && b == null)
    return true;

    // If only one is empty
    if (a == null || b == null)
    return false;

    /* Both non-empty, compare them recursively
    Note that in recursive calls, we pass left
    of one tree and right of other tree */
    return a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left);
  }

  /*
  ­6.Find max path sum in the tree, negative nodes possible
          4
        /   \
       2     6
      / \   / \
     1  3  5   7
               \
                8
  */
  public static int maxPathSumB(TreeNode root) {
    if (root == null) return Integer.MIN_VALUE;
    HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
    Queue<TreeNode> leafs = new LinkedList<TreeNode>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while(!queue.isEmpty()) {
      TreeNode temp = queue.remove();
      if (temp.left != null) {
        queue.add(temp.left);
        map.put(temp.left, temp);
      }
      if (temp.right != null) {
        queue.add(temp.right);
        map.put(temp.right,temp);
      }
      if (temp.right == null & temp.left == null) leafs.add(temp);
    }

    int maxSum = Integer.MIN_VALUE;
    while (!leafs.isEmpty()) {
      TreeNode leaf = leafs.remove();
      int tempSum = leaf.data;
      TreeNode parent = map.get(leaf);
      while (parent != null) {
        tempSum += parent.data;
        if (parent.data < 0) {
          parent = map.get(parent);
          leafs.add(parent);
        } else {
          parent = map.get(parent);
        }
      }
      if (tempSum > maxSum) maxSum = tempSum;
    }

    return maxSum;
  }

  public static int maxPathSum(TreeNode root) {
      int maxValue = Integer.MIN_VALUE;
      return maxPathDown(root, maxValue);
  }

  private static int maxPathDown(TreeNode node, int maxValue) {
      if (node == null) return 0;
      int left = Math.max(0, maxPathDown(node.left, maxValue));
      int right = Math.max(0, maxPathDown(node.right, maxValue));
      maxValue = Math.max(maxValue, left + right + node.data);
      return Math.max(Math.max(left, right) + node.data, maxValue);
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
    // TreeNode n9 = new TreeNode(9);

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    // n8.right = n9;

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

    System.out.println("4.Construct a BST from a sorted array");
    int[] array = {1,2,3,4,5,6,7,8,9};
    TreeNode root = null;
    TreeNode result = constructBST(array, root);
    levelOrder(result);
    System.out.println("-");

    System.out.println("­5.Check if two trees are mirror image of each other");
    TreeNode b1 = new TreeNode(1);
    TreeNode b2 = new TreeNode(2);
    TreeNode b3 = new TreeNode(3);
    TreeNode b4 = new TreeNode(4);
    TreeNode b5 = new TreeNode(5);
    TreeNode b6 = new TreeNode(6);
    TreeNode b7 = new TreeNode(7);
    TreeNode b8 = new TreeNode(8);
    b4.left = b6;
    b2.left = b3;
    b2.right = b1;
    b4.right = b2;
    b6.left = b7;
    b6.right = b5;
    b7.left = b8;
    System.out.println(areMirror(n4,b4));
    System.out.println("-");

    System.out.println("­6.Find max path sum in the tree, negative nodes possible");
    System.out.println(maxPathSum(n4));
    System.out.println("-");

  }
}
