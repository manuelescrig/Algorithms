import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a LinkedList where each node has two pointers. Write a function to
clone the LinkedList.
*/

class LinkedListCloneRandom {

  public static class Node {
    int value;
    Node next;
    Node random;
    public Node(int value) {
      this.value = value;
    }
  }

  public static void print(Node root) {
    Node curr = root;
    while (curr != null) {
      System.out.print(curr.value + ",");
      if (curr.random != null) {
        System.out.print(curr.random.value);
      } else {
        System.out.print("null");
      }
      System.out.print("->");
      curr = curr.next;
    }
    System.out.print("null");
    System.out.println("");
  }

  public static Node clone(Node root) {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node currA = root;
    Node head = new Node(currA.value);
    Node currB = head;

    while (currA.next != null) {
      map.put(currA.value, currA);
      Node next = currA.next;
      Node temp = new Node(next.value);
      currB.next = temp;

      currB = currB.next;
      currA = currA.next;
    }

    currA = root;
    currB = head;
    while (currA != null) {
      currB.random = map.get(currA.random.value);
      currB = currB.next;
      currA = currA.next;
    }

    return head;
  }


  public static Node expand(Node root) {
    Node curr = root;

    while (curr != null) {
      Node temp = new Node(curr.value);
      temp.next = curr.next;
      temp.random = new Node(curr.random.value);
      curr.next = temp;
      curr = temp.next;
    }

    print(root);
    Node currA = root;
    Node currB = root.next;
    Node head = currB;
    while (currA != null) {
      System.out.println(currA.value);
      System.out.println(currB.value);

      currA.next = currA.next.next;
      if (currB.next != null) currB.next = currB.next.next;
      else currB.next = null;

      currA = currA.next;
      currB = currB.next;
    }

    return head;
  }


  public static Node copy(Node n) {
    if (n == null) return null;

    Node nCurr = n;
    while (nCurr != null) {
      Node temp = new Node(nCurr.value);
      temp.next = nCurr.next;
      nCurr.next = temp;
      nCurr = temp.next;
    }

    nCurr = n;
    while (nCurr != null) {
      nCurr.next.random = nCurr.random.next;
      nCurr = nCurr.next.next;
    }

    nCurr = n;
    Node nCurrB = n.next;
    Node copy = nCurrB;
    while (nCurr != null) {

      nCurr.next = nCurr.next.next;

      if (nCurrB.next != null)
        nCurrB.next = nCurrB.next.next;
      else
        nCurrB.next = null;

      nCurr = nCurr.next;
      nCurrB = nCurrB.next;
    }
    return copy;
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    n1.random = n3;
    n2.random = n1;
    n3.random = n3;
    n4.random = n2;
    print(n1);
    Node result = clone(n1);
    print(result);

    System.out.println("---");
    Node expanded = expand(n1);
    print(n1);
    print(expanded);

    System.out.println("---");
    Node copied = copy(n1);
    print(n1);
    print(copied);
  }
}
