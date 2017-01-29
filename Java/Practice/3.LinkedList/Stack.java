import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a Stack using a LinkedList;
*/

class Stack {

  public static class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }

  // 1->null
  public static class MyStack {
    Node top;

    public MyStack() { }

    public void push(int value) {
      // Insert Front;
      Node temp = new Node(value);
      if (top == null) {
        top = temp;
      } else {
        temp.next = top;
        top = temp;
      }
    }

    public int pop() {
      if (top == null) return -1;
      Node next = top.next;
      Node curr = top;
      if (next != null) {
        top.next = next.next;
      }
      top = next;
      return curr.value;
    }

    public int peek() {
      if (top == null) return -1;
      return top.value;
    }

  }

  public static void main (String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    stack.push(4);
    stack.push(5);
    System.out.println(stack.peek());

    }
}
