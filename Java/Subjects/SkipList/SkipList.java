import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a SkipList.
*/

class SkipList {

  public static class Node {
    private int data;
    private Node one_next;  //contain pointer to next node
    private Node two_next;  //pointer to node after the very next node
    public int getData() {
      return data;
    }
    public void setData(int data) {
      this.data = data;
    }
    public Node getOne_next() {
      return one_next;
    }
    public void setOne_next(Node one_next) {
      this.one_next = one_next;
    }
    public Node getTwo_next() {
      return two_next;
    }
    public void setTwo_next(Node two_next) {
      this.two_next = two_next;
    }
  }

  public static class Skiplist{
    Node start;     // Start pointer to skip list
    Node head;
    Node temp_next; // Pointer to store last used fast lane node
    Node end;       // End of skip list
    int length;

    public Skiplist(){
      this.start = new Node();
      this.end = new Node();
      this.length = 0;
      this.temp_next = start;
    }

    public void insert(Node node){
      // if skip list is empty
      if (length == 0) {
        start.setOne_next(node);
        node.setOne_next(end);
        temp_next.setTwo_next(end);
        head = start;
        length++;
      } else {
        length++;
        Node temp = start.getOne_next();
        Node prev = start;

        while(temp != end){
          prev = temp;
          temp = temp.getOne_next();
        }

        if (length %2 == 0) {
          // Add a fast lane pointer for even no of nodes
          prev.setOne_next(node);
          node.setOne_next(end);
          temp_next.setTwo_next(node);
          temp_next=node;
          node.setTwo_next(end);
        } else {
          // Odd no of node will not contain fast lane pointer
          prev.setOne_next(node);
          node.setOne_next(end);
        }
      }
    }

    public void display() {
      System.out.println("--Simple Traversal--");

      Node temp=start.getOne_next();
      while(temp != end) {
        System.out.print(temp.getData()+"=>");
        temp = temp.getOne_next();
      }
    }

    public void displayFast() {
      System.out.println("--Fast Lane Traversal--");

      Node temp=start.getTwo_next();
      while(temp != end) {
        System.out.print(temp.getData()+"==>");
        temp = temp.getTwo_next();
      }
    }
  }

  public static void main (String[] args) {
    Skiplist skiplist=new Skiplist();

    Node n1=new Node();
    Node n2=new Node();
    Node n3=new Node();
    Node n4=new Node();
    Node n5=new Node();
    Node n6=new Node();

    n1.setData(1);
    n2.setData(2);
    n3.setData(3);
    n4.setData(4);
    n5.setData(5);
    n6.setData(6);

    skiplist.insert(n1);
    skiplist.insert(n2);
    skiplist.insert(n3);
    skiplist.insert(n4);
    skiplist.insert(n5);
    skiplist.insert(n6);

    /*print all nodes*/
    skiplist.display();
    System.out.println();
    /* print only fast lane node*/
    skiplist.displayFast();
  }
}
