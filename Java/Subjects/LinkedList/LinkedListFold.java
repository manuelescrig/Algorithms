import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a linked list, write a function to fold the linked list.
1->2->3->4->5->6 is converted to 1->6->2->5->3->4
6->5->4->3->2->1
*/

class LinkedListFold {
  public static class Node {
    int data;
    Node next;
    public Node(int data) {
      this.data = data;
    }
  }

  public static Node fold(Node n) {
    int nodes = countNodes(n);
    Node first = n;
    Node tail = secondHalf(n,nodes);
    Node second = reverse(tail);
    print(first);
    print(second);
    for (int i=0; i<(nodes/2) +1; i++) {
      Node tempA = first.next;
      Node tempB = second.next;
      first.next = second;
      second.next = tempA;
      first = tempA;
      second = tempB;
    }
    return n;
  }

  public static Node secondHalf(Node n, int nodes) {
    Node curr = n;
    int i = 0;
    int half = nodes/2;
    while (i < nodes/2) {
      curr = curr.next;
      i++;
    }
    Node second = curr.next;
    curr.next = null;
    return second;
  }

  public static Node reverse(Node n) {
    Node curr = n;
    Node prev = null;
    Node next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static int countNodes(Node n) {
    if (n == null) return 0;
    Node curr = n;
    int count = 0;
    while (curr != null) {
      curr = curr.next;
      count++;
    }
    return count-1;
  }

  public static void print(Node n) {
    Node curr = n;
    while (curr != null) {
      System.out.print(curr.data + "->");
      curr = curr.next;
    }
    System.out.println("null");
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
    Node temp = fold(n1);
    print(temp);
  }


}
