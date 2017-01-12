import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a Stack with 2 queues.
Stack -> First in, last out.
Queue -> First in, first out

push(1)
push(2)
push(3)
push(4)
pop() -> 4
pop() -> 3

a = 2,1
b =
*/

public class StackTwoQueues {

  public static class MyStack {
    Queue<Integer> a = new LinkedList<Integer>();
    Queue<Integer> b = new LinkedList<Integer>();

    public MyStack() {}

    public void push(int e) {
      a.add(e);
    }

    public int pop() {
      if (a.size() == 0) throw new NullPointerException("");
      while (a.size() > 1) b.add(a.remove());
      int temp = a.remove();
      a = b;
      b = new LinkedList<Integer>();
      return temp;
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
