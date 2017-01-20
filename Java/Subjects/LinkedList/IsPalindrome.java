import java.util.*;
import java.lang.*;
import java.io.*;

/*
Delete a node from a singly-linked list ↴ ,
given only a variable pointing to that node.
*/

class IsPalindrome {

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

  public static Node reverseRecursive(Node n) {
    if (n == null) return null;
    Node head = null;
    head = reverse(n.next, n);
    n.next = null;
    return head;
  }

  public static Node reverse(Node curr, Node prev) {
    if (curr == null) return prev;

    Node next = curr.next;
    curr.next = prev;
    prev = curr;
    return reverse(next, curr);
  }

  public static Node reverseIterative(Node n) {
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

  public static boolean isPalindrome(Node a, Node b) {
    if (a == null || b == null) return false;

    while (a != null && b != null) {
      if (a.data != b.data) return false;
      a = a.next;
      b = b.next;
    }

    return true;
  }
  /*
   LinkedList => 1  2  3  4  5  6
   Slow                   ^
   Fast                         ^
   Stack => [1,2,3,]
  */

  public static boolean palindrome(Node n) {

    Stack<Node> stack = new Stack<Node>();
    Node slow = n;
    Node fast = n;
    boolean isPalindrome = true;

    while (fast != null && fast.next != null) {
      stack.push(slow);
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast !=null) slow = slow.next;
    while (slow != null) {
      Node pop = stack.pop();
      if (pop.data != slow.data) return false;
      slow = slow.next;
    }

    return isPalindrome;
  }

  public static void main (String[] args) {
    Node a1 = new Node(1);
    Node a2 = new Node(2);
    Node a3 = new Node(3);
    Node a4 = new Node(4);
    Node a5 = new Node(5);
    Node a6 = new Node(6);
    a1.next = a2;
    a2.next = a3;
    a3.next = a4;
    a4.next = a5;
    a5.next = a6;

    print(a1);
    Node reversed = reverseIterative(a1);
    print(reversed);

    System.out.println(isPalindrome(a1,reversed));

    Node b1 = new Node(1);
    Node b2 = new Node(2);
    Node b3 = new Node(3);
    Node b4 = new Node(2);
    Node b5 = new Node(1);
    b1.next = b2;
    b2.next = b3;
    b3.next = b4;
    b4.next = b5;
    print(b1);
    Node reversedB = reverseIterative(b1);
    print(reversedB);
    System.out.println(isPalindrome(b1,reversedB));

    System.out.println("---");
    print(a2);
    System.out.println(palindrome(a2));

  }
}
