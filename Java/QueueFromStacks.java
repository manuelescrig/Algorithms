import java.util.*;
import java.lang.*;
import java.io.*;
/*
Implement a Queue with basic functionality (queue and dequeue) using stacks to
store the data.

 queue(2)

 a = []
 b = [4<-3<-2<-1]

*/
class QueueFromStacks {

  public static class MyQueue {
    Stack<Integer> a = new Stack<Integer>();
    Stack<Integer> b = new Stack<Integer>();

    public MyQueue() { }

    public void queue(int e) {
      a.push(e);
    }

    public int dequeue() {
      while (a.size() > 0) {
        b.push(a.pop());
      }
      return b.pop();
    }
  }

  public static void main (String[] args) {
    MyQueue queue = new MyQueue();
    queue.queue(1);
    queue.queue(2);
    queue.queue(3);

    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    queue.queue(4);
    queue.queue(5);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());

  }
}
