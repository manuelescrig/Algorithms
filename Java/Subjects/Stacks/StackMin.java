import java.util.*;
import java.lang.*;
import java.io.*;

/*
Design a Stack with a push, pop and min function which returns the max value
in the stack, all of which are run in O(n).
stack = (5,inf)
min = 5

push(5)
push(4)
push(8)
push(2)
push(3)

pop() -> 3
pop() -> 2
pop() -> 8
pop() -> 4

*/

class StackMin {

  public static class MinStack {
    private static class Node {
      int element;
      int min;
      public Node(int e, int min) {
        this.element = e;
        this.min = min;
      }
    }
    private static Stack<Node> stack = new Stack<Node>();
    private static int min = Integer.MAX_VALUE;

    public MinStack() { }

    public static void push(int e) {
      if (e < min) {
        Node node = new Node(e, min);
        min = e;
        stack.push(node);
      } else {
        Node node = new Node(e,min);
        stack.push(node);
      }
    }

    public static int pop() {
      Node temp = stack.pop();
      min = temp.min;
      return temp.element;
    }

    public static int min() {
      return min;
    }

  }


  public static void main (String[] args) {
    MinStack stack = new MinStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    System.out.println("m: " + stack.min()); // 1
    System.out.println(stack.pop()); // 4
    System.out.println(stack.pop()); // 3
    System.out.println(stack.pop()); // 2
    System.out.println(stack.pop()); // 1
    stack.push(4);
    stack.push(8);
    stack.push(3);
    stack.push(2);
    System.out.println("m: " + stack.min()); // 2
    System.out.println(stack.pop()); // 2

    System.out.println("m: " + stack.min()); // 3
    System.out.println(stack.pop()); // 3
    System.out.println("m: " + stack.min()); // 4
    System.out.println(stack.pop()); // 8
  }
}
