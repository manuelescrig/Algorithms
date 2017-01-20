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
    int capacity;
    int currentCapacity;
    int numberOfStacks;
    int[] array;
    HashMap<Integer, Integer> map;

    public Stacks(int capacity, int numberOfStacks) {
      this.capacity = capacity;
      this.currentCapacity = 0;
      this.numberOfStacks = numberOfStacks;
      this.array = new int[capacity];
      this.map = new HashMap<Integer,Integer>();
    }

    private int getIndex(int stackId) {
      int index = 0;
      for (int key : map.keySet()) {
        if (key <= stackId) {
          index += map.get(key);
        }
      }
      return index;
    }

    public void print() {
      for (int value : array) {
        System.out.print(value + " ");
      }
      System.out.println("");
    }

    public void push(int value, int stackId)  {
      if (currentCapacity < capacity && map.size() < numberOfStacks) {
        if (!map.containsKey(stackId)) {
          map.put(stackId,1);
        } else {
          int size = map.get(stackId);
          map.put(stackId, ++size);
        }
        currentCapacity++;

        int index = getIndex(stackId);
        index--;
        int currentIndex = currentCapacity-1;
        while (currentIndex > index) {
          array[currentIndex] = array[currentIndex-1];
          currentIndex--;
        }
        array[index] = value;
      } else {
        throw new IndexOutOfBoundsException("");
      }
    }

    public int pop(int stackId) {
      if (map.containsKey(stackId)) {
        int size = map.get(stackId);
        if (size <= 0) {
          throw new IndexOutOfBoundsException("");
        }
        int index = getIndex(stackId);
        index--;

        int value = map.get(stackId);
        map.put(stackId, --value);

        int popValue = array[index];
        while (index < capacity-1) {
          array[index] = array[index+1];
          index++;
        }
        return popValue;
      } else {
        throw new IndexOutOfBoundsException("");
      }
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
