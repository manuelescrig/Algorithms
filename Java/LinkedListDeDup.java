import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given an unsorted linked list, write a function to remove all the
duplicates.
dedup( 1->2->3->2->1 )  => 1->2->3
*/

class LinkedListDeDup {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

  }

  public static Node dedup(Node n) {
    HashSet<Integer> set = new HashSet<Integer>();
    Node prev = null;
    Node curr = n;
    Node head = curr;
    while (curr != null) {
      if (set.contains(curr.data)) {
        prev.next = curr.next;

      } else {
        set.add(curr.data);
        prev = curr;
      }
      curr = curr.next;
    }
    return head;
  }

  public static void dedupNoStorage(Node n) {

    Node nOuter = n;

    while (nOuter != null) {

      Node nPrev = nOuter;
      Node nInner = nOuter.next;
      while (nInner != null) {

        if (nInner.data == nOuter.data) {
          nPrev.next = nInner.next;
        } else {
          nPrev = nInner;        
        }
        nInner = nInner.next;
      }
      nOuter = nOuter.next;
    }
  }

  public static Node arrayToLinkedList(int[] a) {
      Node temp = null;
      for (int i=a.length-1; i>=0; i--) {
        Node curr = new Node(a[i]);
        curr.next = temp;
        temp = curr;
      }

      return temp;
  }

  public static void print(Node n) {
    Node curr = n;
    while(curr != null) {
        System.out.print(curr.data + "->");
        curr = curr.next;
    }
    System.out.println("null");
  }

  public static void main (String[] args) {
    int[] array = {1,2,3,2,1};
    Node n = arrayToLinkedList(array);
    print(n);
    // Node dedup = dedup(n);
    // print(dedup);
    dedupNoStorage(n);
    print(n);
  }
}
