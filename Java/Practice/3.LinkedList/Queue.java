import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a Queue using a LinkedList;
*/

class Queue {

  public static class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }
  //   2->1->null
  //   ^  ^

  public static class MyQueue {
    Node first;
    Node last;
    public MyQueue() {}

    public void enqueue(int value) {
      Node node = new Node(value);
      if (first == null) {
        first = node;
        last = node;
      } else {
        last.next = node;
        last = node;
      }
    }

    public int dequeue() {
      if (first == null) return -1;
      int value = first.value;
      first = first.next;
      return value;
    }
  }

  public static void main (String[] args) {
    MyQueue queue = new MyQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
}

}
