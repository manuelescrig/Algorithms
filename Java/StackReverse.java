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

class StackReverse {

  public static Stack<Integer> reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) return stack;
    int temp = stack.pop();
    reverse(stack);
    insertAtBottom(stack,temp);
    return stack;
  }

  public static void insertAtBottom(Stack<Integer> stack, int value) {
    if (stack.isEmpty()) {
      stack.push(value);
      return;
    }
    int temp = stack.pop();
    insertAtBottom(stack, value);
    stack.push(temp);
  }

  public static void main (String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    Stack<Integer> reversed = reverse(stack);
    while (!reversed.isEmpty()) {
      System.out.println(reversed.pop());
    }
    System.out.println("-");
  }
}
