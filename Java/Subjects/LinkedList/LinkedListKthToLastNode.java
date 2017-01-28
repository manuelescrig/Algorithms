import java.util.*;
import java.lang.*;
import java.io.*;

/*
You have a linked list and want to find the kth to last node.
Write a function kthToLastNode() that takes an integer
and the headNode of a singly linked list, and returns the
kth to last node in the list.
*/

class LinkedListKthToLastNode {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void print(Node n) {
    while (n != null) {
      System.out.print(n.data + "-");
      n = n.next;
    }
    System.out.println("null");
  }

  public static void delete(Node n) {
    if (n == null) return;
    Node next = n.next;
    n.data = next.data;
    n.next = next.next;
  }

  public static Node reverse(Node n) {
    Node curr = n;
    Node prev = null;
    Node next = null;

    while (curr != null) {
      next = curr.next;
      curr.next =  prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static int findKthToLast(Node head, int k) {
    if (k <= 0) return -1;
    Node first = head;
    Node second = head;

    while (first != null) {
      if (k <= 0) {
          second = second.next;
      } else  {
        k--;
      }
      first = first.next;
    }
    return second.data;
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;

    print(n1);
    System.out.println(findKthToLast(n1,10));
    delete(n4);
    print(n1);
    Node temp = reverse(n1);
    print(temp);
  }
}
