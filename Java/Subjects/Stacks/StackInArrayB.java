import java.util.*;
import java.lang.*;
import java.io.*;
/*
Create N stacks in an array.
Stacks
Capacity
Number of stacks

new Stacks(capacity, num stacks)
push(value, stack id)
pop(stack id)

---
number of stacks  = 3
capacity = 6
currentCapacity = 0;
map = {1,3} {2,1}
array = {  1, 2, 3 ,, , , , }

Stacks(6,3)
push (1, 1)
push (2, 1)
push (3, 2)
push (4, 1)
pop (1) -> 4


*/
class StackInArray {

  public static class Stacks {
    int[] topOfStacks;
    int[] stackData;
    int[] nextIndex;
    int nextAvailable = 0;

    public Stacks(int capacity, int numberOfStacks) {
      this.topOfStacks = new int[numberOfStacks];
      for (int val : this.topOfStacks) {
        val = -1;
      }
      this.stackData = new int[capacity];
      this.nextIndex = new int[capacity];
      for (int i=0; i<this.nextIndex.length-1; i++){
        this.nextIndex[i] = i+1;
      }
      this.nextIndex[nextIndex.length-1] = -1;
    }

    public void push(int value, int stack) {
      if (stack < 0 || stack > topOfStacks.length) {
        throw new IndexOutOfBoundsException("");
      }
      if (nextAvailable < 0) return;
      int currentIndex = nextAvailable;
      nextAvailable = nextIndex[currentIndex];
      stackData[currentIndex] = value;
      nextIndex[currentIndex] = topOfStacks[stack];
      topOfStacks[stack] =  currentIndex;
    }

    public int pop(int stack) {
      if (stack < 0 || stack > topOfStacks.length || topOfStacks[stack] < 0) {
        throw new IndexOutOfBoundsException("");
      }
      int currentIndex = topOfStacks[stack];
      int value = stackData[currentIndex];
      topOfStacks[stack] = nextIndex[currentIndex];
      nextIndex[currentIndex] = nextAvailable;
      nextAvailable = currentIndex;
      return value;
     }

    public void print() {
      for (int value : stackData) {
        System.out.print(value + " ");
      }
      System.out.println("");
    }
  }

  public static void main (String[] args) {
    Stacks stacks = new Stacks(6,3);
    stacks.push(1, 1);
    stacks.print();

    stacks.push (2, 1);
    stacks.print();

    stacks.push (3, 2);
    stacks.print();

    stacks.push (5, 2);
    stacks.print();

    stacks.push (4, 1);
    stacks.print();

    int value = stacks.pop(1);
    System.out.println(value);
    stacks.print();

    value = stacks.pop(2);
    System.out.println(value);
    stacks.print();
  }
}
