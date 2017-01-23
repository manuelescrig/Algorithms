import java.util.*;
import java.lang.*;
import java.io.*;

/*
We are given queue data structure, the task is to implement stack
using only given queue data structure.
*/

public class StackOneQueue {
  public static class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();

    public void push(int e) {
      queue.add(e);

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        queue.add(queue.element());
        queue.remove();
      }
    }

    public int pop() {
      if (queue.isEmpty()) throw new IllegalArgumentException("");
      else return queue.remove();
    }

    public int peek() {
      if (queue.isEmpty()) throw new IllegalArgumentException("");
      else return queue.element();
    }

  }

  public static void main(String args[]) {
    MyStack stack = new MyStack();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.push(2);
    stack.push(3);
    System.out.println(stack.pop());

  }
}
