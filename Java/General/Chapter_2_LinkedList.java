import java.util.*;
import java.lang.*;
import java.io.*;
/*
Questions
1.Reverse a singly linked list
2.Delete/Insert a node in a linked list
3.Detect if there is a cycle in the list and return its starting point
­4.Merge two sorted lists
­5.Split a list into two lists one has even indexes other has odd indexes
*/

class Chapter_2_LinkedList {

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

  public static Node insertLast(Node head, int e) {
    Node n = new Node(e);
    if (head == null) return n;
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = n;
    return head;
  }

  public static Node insertFirst(Node head, int e) {
    Node n = new Node(e);
    if (head == null) return n;
    n.next = head;
    return n;
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

  public static Node reverseList(Node A) {
    if (A == null) return A;

    Node node;
    node = rec(A.next, A);
    A.next = null;
    return node;
  }

  public static Node rec(Node curr, Node prev) {
    if (curr == null) return prev;

    Node temp = curr.next;
    curr.next = prev;
    return rec(temp, curr);
  }

  public static void recursiveReversePrint(Node n) {
    if (n == null) return;
    recursiveReversePrint(n.next);
    System.out.println(n.data);
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

  public static Node deleteAll(Node head, int k) {
    Node curr = head;
    Node prev = null;

    while (curr != null) {
        if (curr.data == k) {
          Node next = curr.next;
          if (next != null) {
            curr.data = next.data;
            curr.next = next.next;
          } else  {
            prev.next = null;
            break;
          }
        } else {
          prev = curr;
          curr = curr.next;
        }
    }

    return head;
  }

  public static Node shufflesThemTogether(Node a, Node b) {

    Node currA = a;
    Node currB = b;
    Node tempA;
    Node tempB;

    while (currA != null) {
      tempA = currA.next;
      currA.next = currB;
      tempB = currB.next;
      currB.next = tempA;
      currA = tempA;
      currB = tempB;
    }

    return a;
  }

  public static Node arrayToLinkedList(int[] array) {
    if (array == null) return null;

    Node temp = null;

    for (int i = array.length-1; i>=0; i--) {
      Node n = new Node(array[i]);
      n.next = temp;
      temp = n;
    }
    return temp;
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

    insertLast(temp, 10);
    insertLast(temp, 5);
    insertLast(temp, 5);
    insertLast(temp, 6);
    insertLast(temp, 5);
    insertLast(temp, 5);
    insertLast(temp, 5);
    print(temp);

    temp = insertFirst(temp, 11);
    temp = insertFirst(temp, 5);
    temp = insertFirst(temp, 5);
    print(temp);

    temp = deleteAll(temp, 5);
    print(temp);

    System.out.println("---");
    Node a = new Node(1);
    insertLast(a, 2);
    insertLast(a, 3);
    insertLast(a, 4);
    insertLast(a, 5);
    print(a);
    Node b = new Node(10);
    insertLast(b, 20);
    insertLast(b, 30);
    insertLast(b, 40);
    insertLast(b, 50);
    print(b);
    Node result = shufflesThemTogether(a,b);
    print(result);

    System.out.println("---");
    int[] array = {1,2,3,4,5,6,8,10,11};
    Node linkedListArray = arrayToLinkedList(array);
    print(linkedListArray);

    System.out.println("---");
    recursiveReversePrint(linkedListArray);

    System.out.println("---");
    print(linkedListArray);
    Node reversed = reverseList(linkedListArray);
    print(reversed);

  }
}
