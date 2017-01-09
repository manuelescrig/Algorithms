import java.util.*;
import java.lang.*;
import java.io.*;
/*
*/
class LinkedListCycle {
  public static class Node {
    int value;
    Node next;
  }

  public static boolean hasCycle(Node n) {
    HashSet<Integer> visited = new HashSet<>();
    for (Node curr = n; curr != null; curr = curr.next) {
      if (visited.contains(curr)) return true;
      visited.add(curr);
    }
    return false;
  }

  public static boolean hasCycle(Node n) {
    if (n == null) return false;
    Node slow = n;
    Node fast = n.next;

    while(fast != null && fast.next != null) {
      if (fast == slow) return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }  

  public static void main (String[] args) {
  }
}
