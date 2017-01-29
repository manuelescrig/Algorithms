import java.util.*;
import java.lang.*;
import java.io.*;

/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a
single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

class AddTwoNumbers {

  public static class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }

  public static void print(Node n) {
    Node curr = n;
    while (curr != null) {
      System.out.print(curr.value + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static Node reverse(Node n) {
    if (n == null) return null;
    Node curr = n;
    Node prev = null;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static int sumNodes(Node n) {
    if (n == null) return 0;
    int sum = 0;
    int index = 1;
    Node curr = n;

    while (curr != null) {
      sum += (curr.value * index);
      curr = curr.next;
      index *= 10;
    }
    return sum;
  }

  public static Node sum(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;
    Node rA = reverse(a);
    Node rB = reverse(b);
    int result = sumNodes(rA) + sumNodes(rB);
    Node temp = null;
    while (result > 0) {
      temp = insertFront(temp, result % 10);
      result = result / 10;
    }

    return temp;
  }

  public static Node insertFront(Node node, int value) {
    Node temp = new Node(value);
    temp.next = node;
    return temp;
  }

  public static void main (String[] args) {
    Node n1 = new Node(2);
    Node n2 = new Node(4);
    Node n3 = new Node(3);
    n1.next = n2;
    n2.next = n3;
    print(n1);

    Node n4 = new Node(5);
    Node n5 = new Node(6);
    Node n6 = new Node(4);
    n4.next = n5;
    n5.next = n6;
    print(n4);

    Node result = sum(n1,n4);
    print(result);
  }
}
