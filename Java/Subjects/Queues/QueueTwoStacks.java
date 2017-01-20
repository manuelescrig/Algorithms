import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a Queue with 2 stacks.
Stack -> First in, last out.
Queue -> First in, first out

queue(1)
queue(2)
queue(3)
dequeue() -> 1
dequeue() -> 2
queue(4)
queue(5)
dequeue() -> 3

a = 4
b = 5
*/

public class QueueTwoStacks {

  public static class MyQueue {
    Stack<Integer> a = new Stack<Integer>();
    Stack<Integer> b = new Stack<Integer>();

    public MyQueue() {}

    public void queue(int e) {
      a.push(e);
    }

    public int dequeue() {
      if (b.size() > 0) {
        return b.pop();
      } else {
        while (a.size() > 1) b.push(a.pop());
        return a.pop();
      }
    }
  }

  public static void main(String args[]) {
    MyQueue queue = new MyQueue();
    queue.queue(1);
    queue.queue(2);
    queue.queue(3);
    System.out.println(queue.dequeue()); // -> 1
    System.out.println(queue.dequeue()); // -> 2
    queue.queue(4);
    queue.queue(5);
    System.out.println(queue.dequeue()); // -> 3

  }
}
