import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a linked list, write a function to reverse every k nodes
(where k is an input to the function).
Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
Output:  3->2->1->6->5->4->8->7->NULL

Inputs:  1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL
*/

class LinkedListReverseInGroups {
  public static class Node {
    int data;
    Node next;
    public Node(int data) {
      this.data = data;
    }
  }

  public static void print(Node n) {
    Node curr = n;
    while (curr != null) {
      System.out.print(curr.data + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static Node reverse(Node n, int k) {
    if (n == null) return null;

    int count = 0;
    Node prev = null;
    Node next = null;
    Node curr = n;

    while (curr != null && count < k) {
      count++;
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    if (next != null) n.next = reverse(next, k);
    return prev;
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

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    print(n1);
    Node reversed = reverse(n1, 3);
    print(reversed);
  }


}
