import java.util.*;
import java.lang.*;
import java.io.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists
in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently
used item before inserting a new item.
*/

class LRUCache {

  public static class Node {
    int key;
    int value;
    Node next;
    Node pre;
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public static class Cache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public Cache(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (map.containsKey(key)) {
        Node n = map.get(key);
        remove(n);
        setHead(n);
        return n.value;
      }
      return -1;
    }

    public void remove(Node n){
      if (n.pre != null) {
        n.pre.next = n.next;
      } else {
        head = n.next;
      }

      if (n.next!=null) {
        n.next.pre = n.pre;
      } else {
        end = n.pre;
      }
    }

    public void setHead(Node n){
      n.next = head;
      n.pre = null;

      if (head!=null) head.pre = n;
      head = n;
      if (end ==null) end = head;
    }

    public void set(int key, int value) {
      if (map.containsKey(key)) {
        Node old = map.get(key);
        old.value = value;
        remove(old);
        setHead(old);
      } else {
        Node created = new Node(key, value);
        if( map.size() >= capacity) {
          map.remove(end.key);
          remove(end);
          setHead(created);

        } else {
          setHead(created);
        }

        map.put(key, created);
      }
    }
  }

  public static void main (String[] args) {
    Cache cache = new Cache(4);
    cache.set(1,100);
    cache.set(2,200);
    cache.set(3,300);
    cache.set(4,400);
    cache.set(5,500);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));

  }
}
