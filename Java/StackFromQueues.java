import java.util.*;
import java.lang.*;
import java.io.*;
/*
Implement a Stack with basic functionality (push and pop) using queues to
store the data.

 1
 2   2
 3   3
 -   -

 a = [1]
 b = [2]

*/
class StackFromQueues {

  public static class MyStack {
    Queue<Integer> a = new LinkedList<Integer>();
    Queue<Integer> b = new LinkedList<Integer>();

    public MyStack() { }

    public void push(int e) {
      a.add(e);
    }

    public int pop() {
      while(a.size() > 1) {
        b.add(a.remove());
      }
      if (a.size() == 0) throw new IndexOutOfBoundsException();
      int value = a.remove();
      Queue<Integer> temp = a;
      a = b;
      b = temp;
      return value;
    }

  }

  public static void main (String[] args) {
    MyStack stack = new MyStack();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
