import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a linked list and two keys in it, swap nodes for two given keys.
Nodes should be swapped by changing links. Swapping data of nodes may be
expensive in many situations when data contains many fields.
Input:  10->15->12->13->20->14,  x = 12, y = 20
Output: 10->15->20->13->12->14

Input:  10->15->12->13->20->14,  x = 10, y = 20
Output: 20->15->12->13->10->14

Input:  10->15->12->13->20->14,  x = 12, y = 13
Output: 10->15->13->12->20->14

Edge cases:
This may look a simple problem, but is interesting question as it has following cases to be handled.
1) x and y may or may not be adjacent.
2) Either x or y may be a head node.
3) Either x or y may be last node.
4) x and/or y may not be present in linked list.

*/

class LinkedListSwapNodes {

  public static class Node {
    int data;
    Node next;
    public Node(int data) {
      this.data = data;
    }
  }

  public static Node swap(Node head, Node x, Node y) {
    Node newHead = head;
    Node prevX = prevNode(head, x);
    Node prevY = prevNode(head, y);

    if (prevX != null) {
      prevX.next = y;
    } else {
      newHead = y;
    }
    if (prevY != null) {
      prevY.next = x;
    } else {
      newHead = x;
    }
    Node temp = x.next;
    x.next = y.next;
    y.next = temp;
    return newHead;
  }

  public static Node prevNode(Node head, Node x) {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      if (curr == x) return prev;
      prev = curr;
      curr = curr.next;
    }
    return prev;
  }

  public static void print(Node n) {
    while (n != null) {
      System.out.print(n.data + "->");
      n = n.next;
    }
    System.out.println("null");
  }

  public static void main (String[] args) {
    Node n1 = new Node(10);
    Node n2 = new Node(15);
    Node n3 = new Node(12);
    Node n4 = new Node(13);
    Node n5 = new Node(20);
    Node n6 = new Node(14);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;

    print(n1);
    Node result = swap(n1, n3, n5);
    // Node result = swap(n1, n3, n4);
    // Node result = swap(n1, n1, n5);
    print(result);
  }
}
