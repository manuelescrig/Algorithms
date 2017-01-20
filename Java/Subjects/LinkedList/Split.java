import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a LinkedList, write a function that divides it into two halves.
This function should modify the original list and then return a pointer to
the second half.
Example 1
l = 1->2->3->4
       ^
              ^
r = devide(l)
l = 1->2
r = 3->4

Example 2
l = 1->2->3->4->5
       ^
                  ^
r = devide(l)
l =
r =

Example 3
l = 1
r = devide(l)
l =
r =

*/

class Split {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
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

  /*
  l = 1->2->3->4->5->null
            ^
                     ^
  r = devide(l)
  l = 1->2
  r = 3->4
  */

  public static Node split(Node head) {
    if (head == null) return null;

    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null ) {
      slow = slow.next;
      fast = fast.next.next;
    }

    Node secondHalf = slow.next;
    slow.next = null;
    return secondHalf;
  }

  public static Node splitOdd(Node head) {
    if (head == null) return null;

    Node slow = head;
    Node fast = head.next;
    Node prev = null;
    while (fast != null && fast.next != null ) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast == null) {
      Node secondHalf = prev.next;
      prev.next = null;
      return secondHalf;
    } else {
      Node secondHalf = slow.next;
      slow.next = null;
      return secondHalf;
    }
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
    // n5.next = n6;
    print(n1);
    Node result = split(n1);
    System.out.println("---");
    print(n1);
    print(result);
  }
}
