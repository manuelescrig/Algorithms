import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.
*/

class LinkedListToBalancedBST {

  static class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
      this.data = data;
    }
  }

  static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
      this.data = data;
    }
  }

  public static void printTree(TreeNode root) {
    if (root == null) return;

    printTree(root.left);
    System.out.print(root.data + " ");
    printTree(root.right);
  }

  public static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.data + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static int getListLength(ListNode head) {
    if (head == null) return 0;
    int length = 0;
    ListNode curr = head;
    while (curr != null) {
      length++;
      curr = curr.next;
    }
    return length;
  }

  public static ListNode insertFront(ListNode head, int value) {
      ListNode node = new ListNode(value);
      node.next = head;
      return node;
  }

  // 1,2,3,4,5,6
  public static ListNode arrayToLinkedList(int[] array) {
    if (array == null || array.length == 0) return null;

    ListNode temp = null;
    for (int i = array.length-1; i >= 0; i--) {
      temp = insertFront(temp,array[i]);
    }
    return temp;
  }

  static ListNode h;

  // 1->2->3->4->5->6->null
  public static TreeNode listToBalancedBST(ListNode list) {
    if (list == null) return null;

    int listLength = getListLength(list);
    h = list;
    return buildTreeFromList(0, listLength - 1);
  }

  public static TreeNode buildTreeFromList(int start, int end) {
    if (start > end) return null;

    int mid = (start + end) / 2;
    TreeNode left = buildTreeFromList(start, mid-1);
    TreeNode root = new TreeNode(h.data);
    h = h.next;
    TreeNode right = buildTreeFromList(mid+1, end);

    root.left = left;
    root.right = right;
    return root;
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

    n4.left = n2;
    n2.left = n1;
    n2.right = n3;
    n4.right = n6;
    n6.left = n5;
    n6.right = n7;
    n7.right = n8;
    printTree(n4);
    System.out.println("-");

    int[] array = {1,2,3,4,5,6};
    ListNode list = arrayToLinkedList(array);
    printList(list);

    TreeNode result = listToBalancedBST(list);
    printTree(result);
  }
}
