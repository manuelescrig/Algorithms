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


class ReverseStack {

  public static void reverse(Stack<Integer> stack, Integer value, Integer size) {

    if (stack.isEmpty()) {
      return;
    }

    int temp = stack.pop();
    reverse(stack, value, size);
    stack.push(temp);

    if (temp == size) {
      stack.push(value);
    }
  }


  public static void main(String args[]) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);

    System.out.println(stack.toString());
    int pop = stack.pop();
    reverse(stack, pop, stack.size()-1);
    System.out.println(stack.toString());


   }
}
