import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a Stack, reverse items in the Stack without using any additional
data structures.

  1
  2
  3
  4
|___|    |___|    |___|
*/

class StackReverse {

  public static <T> void reverseStack(Stack<T> stack) {
      if (stack.isEmpty()) return;

      // Remove bottom element from stack
      T bottom = popBottom(stack);

      // Recurse reversing everything else in stack
      reverseStack(stack);

      // Add original bottom element to top of stack
      stack.push(bottom);
  }
  private static <T> T popBottom(Stack<T> stack) {
      T top = stack.pop();
      if (stack.isEmpty()) {
          // If we removed the last element, return it
          return top;
      } else {
          // We didn't remove the last element, so remove the last element from what remains
          T bottom = popBottom(stack);
          // Since the element we removed in this function call isn't the bottom element, add it back onto the top of the stack where it came from
          stack.push(top);
          return bottom;
      }
  }

  public static void main(String args[]) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);

    System.out.println(stack.toString());
    reverseStack(stack);
    System.out.println(stack.toString());
  }
}
