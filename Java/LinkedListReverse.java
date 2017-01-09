import java.util.*;
import java.lang.*;
import java.io.*;
/*
Delete a node from a singly-linked list ↴ ,
given only a variable pointing to that node.
*/

class LinkedListReverse {

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
      System.out.print(n.data + "->");
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
    delete(n4);
    print(n1);
    Node temp = reverse(n1);
    print(temp);
  }
}
