import java.util.*;
import java.lang.*;
import java.io.*;

/*
Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.

Analysis -
The simplest solution is using PriorityQueue.
The elements of the priority queue are ordered according to their natural
ordering, or by a comparator provided at the construction time (in this case).
*/

class MergeKSortedLists {

  public static class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }

  public static Node mergeKLists(Node[] lists) {
    if (lists==null || lists.length==0) return null;

    PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>(){
      public int compare(Node l1, Node l2){
        return l1.value - l2.value;
      }
    });

    Node head = new Node(0);
    Node p = head;

    for (Node list: lists) {
      if (list!=null) queue.add(list);
    }

    while (!queue.isEmpty()) {
      Node n = queue.poll();
      p.next = n;
      p=p.next;

      if (n.next!=null) queue.add(n.next);
    }
    return head.next;
  }

  public static void print(Node n) {
    Node curr = n;
    while (curr != null) {
      System.out.print(curr.value + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static void main (String[] args) {
    Node n1 = new Node(2);
    Node n2 = new Node(4);
    Node n3 = new Node(3);
    n1.next = n2;
    n2.next = n3;

    Node n4 = new Node(5);
    Node n5 = new Node(6);
    Node n6 = new Node(4);
    n4.next = n5;
    n5.next = n6;
    Node[] lists = {n1,n4};
    Node result = mergeKLists(lists);
    print(result);
  }
}
