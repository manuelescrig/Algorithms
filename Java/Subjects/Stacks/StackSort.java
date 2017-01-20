import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a stack, sort the elements in the stack using no more than one
additional stack.


  4
  1           2
  3           3
  2     4     1
  -     -     -
temp = 2
a =
*/

class StackSort {

  // Option A
  public static void sortStack(Stack<Integer> stack) {
    Stack<Integer> tempStack = new Stack<Integer>();
    boolean isSorted = false;
    while (isSorted == false) {
      isSorted = true;
      sort(stack, tempStack);
      while(!tempStack.isEmpty()) {
        int temp = tempStack.pop();
        if (!tempStack.isEmpty() && temp < tempStack.peek()) isSorted = false;
        stack.push(temp);
      }
    }
  }

  public static void sort(Stack<Integer> stack, Stack<Integer> tempStack) {
    int tempElement = 0;
    tempStack.push(stack.pop());
    while (!stack.isEmpty()) {
      if (stack.peek() > tempStack.peek()) {
        tempStack.push(stack.pop());
      } else {
        tempElement = tempStack.pop();
        tempStack.push(stack.pop());
        tempStack.push(tempElement);
      }
    }
  }

  // Option B
  /*
    4           1
    1           2
    3           3
    2           4
    -     -     -
    temp  =
  */
  public static Stack<Integer> sortStackB(Stack<Integer> stack) {
    if (stack == null || stack.isEmpty()) return stack;
    Stack<Integer> newStack = new Stack<Integer>();
    newStack.push(stack.pop());

    while (!stack.isEmpty()) {
      int temp = stack.pop();
      while (!newStack.isEmpty() && temp > newStack.peek()) {
        stack.push(newStack.pop());
      }
      newStack.push(temp);
    }
    return newStack;
  }

  public static void main (String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(2);
    stack.push(3);
    stack.push(1);
    stack.push(4);

    // sortStack(stack);
    // System.out.println("-");
    // while (!stack.isEmpty()) {
    //   System.out.println(stack.pop());
    // }
    // System.out.println("-");

    Stack<Integer> result = sortStackB(stack);
    while (!result.isEmpty()) {
      System.out.println(result.pop());
    }
    System.out.println("-");

  }
}
