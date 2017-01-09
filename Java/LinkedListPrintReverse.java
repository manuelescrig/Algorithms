import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a linked list, write a function that prints the nodes of the list in
reverse order.
Eg. 1->2->3
3
2
1
*/

class LinkedListPrintReverse {
  private static class Node {
    int value;
    Node next;
    Node (int value) {
      this.value = value;
    }
  }

  public static void print(Node n) {
    Node curr = n;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }

 /*
 1->2->3->4
 printReverse(1)
 printReverse(2)
 printReverse(3)
 printReverse(4)
 4
 3
 2
 1
 */
  public static void printReverse(Node n) {
    if (n == null) return;
    printReverse(n.next);
    System.out.println(n.value);
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    print(n1);
    printReverse(n1);
  }


}
