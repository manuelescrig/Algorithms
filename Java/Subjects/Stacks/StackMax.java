import java.util.*;
import java.lang.*;
import java.io.*;

/*
Design a Stack with a push, pop and max function which returns the max value
in the stack, all of which are run in O(n).
*/

class StackMax {

  public static class MaxStack {

    private class Node {
        int value;
        Node next;
        Node oldMax;
    }

    private Node stack;
    private Node max;

    public MaxStack() { }

    public void push(int element) {
      Node node = new Node();
      node.value = element;
      if (stack == null) {
        stack = node;
      } else {
        node.next = stack;
        stack = node;
      }
      if (max == null || element > max.value) {
        node.oldMax = max;
        max = node;
      }
    }

    public int pop() {
      if (stack == null) throw new NullPointerException();
      Node temp = stack;
      stack = temp.next;
      if (temp.oldMax != null) {
        max = temp.oldMax;
      }
      return temp.value;
    }

    public int max() {
      if (max == null) throw new NullPointerException();
      return max.value;
    }
  }


  public static void main (String[] args) {
    MaxStack stack = new MaxStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    System.out.println("m: " + stack.max());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.push(4);
    stack.push(8);
    stack.push(5);

    System.out.println("m: " + stack.max());
    System.out.println(stack.pop());
    System.out.println("m: " + stack.max());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
