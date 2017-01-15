import java.util.*;
import java.lang.*;
import java.io.*;
/*
Questions
1.Reverse a singly linked list
2.Delete/Insert a node in a linked list
3.Detect if there is a cycle in the list and return its starting point
­4.Merge two sorted lists
­5.Split a list into two lists one has even indexes other has odd indexes
6.Find kth to last node
7.Delete all nodes with value k
8.Shuffles two list together
9.Array list to linked list
10.Remove kth to last node
*/

class Chapter_2_LinkedList {

  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void print(Node n) {
    while (n != null) {
      System.out.print(n.data + "->");
      n = n.next;
    }
    System.out.println("null");
  }

  public static void printRecursive(Node n) {
    if (n == null) {
      System.out.println("null");
      return;
    }
    System.out.print(n.data + "->");
    printRecursive(n.next);
  }

  public static void printRecursiveReversed(Node n) {
    if (n == null) {
      return;
    }
    Node temp = n;
    printRecursiveReversed(n.next);
    System.out.print(temp.data + "->");
  }

  /*
  1.Reverse a singly linked list
  */
  public static Node reverse(Node n) {
    if (n == null) return null;

    Node next = n.next;
    Node curr = n;
    Node prev = null;
    while (next != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  // public static Node reverseRecursive(Node n) {
  //   if (n == null) return n;
  //
  //   Node head;
  //   head = recurse(n.next, n);
  //   n.next = null;
  //   return head;
  // }
  // public static Node recurse(Node curr, Node prev) {
  //   if (curr == null) return prev;
  //
  //   Node next = curr.next;
  //   curr.next = prev;
  //   return recurse(next, curr);
  // }

  public static Node reverseRecursive(Node head) {
    if (head == null || head.next == null) return head;

    Node next = head.next;
    head.next = null;
    Node rest = reverseRecursive(next);
    next.next = head;
    return rest;
}

  /*
  2.Delete a node in a linked list
  */
  public static void delete(Node root, Node n) {
    if (root == null || n == null) return;

    Node curr = root;
    Node prev = null;
    while (curr != null && curr != n) {
      prev = curr;
      curr = curr.next;
    }
    if (prev == null) {
      Node next = root.next;
      n.data = next.data;
      n.next = next.next;
    } else if (curr == null) {
      prev.next = null;
    } else {
      prev.next = curr.next;
    }
  }

  /*
  2.Insert a node last in a linked list
  */
  public static void insertLast(Node head, Node n) {
    if (head == null || n == null) return;

    Node curr = head;
    while (curr.next != null) { curr = curr.next; }
    curr.next = n;
  }

  public static Node insertLast(Node head, int e) {
    Node n = new Node(e);
    if (head == null) return n;
    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = n;
    return head;
  }

  /*
  2.Insert a node first in a linked list
  */
  public static Node insertFirst(Node head, Node n) {
    if (head == null || n == null) return n;
    n.next = head;
    return n;
  }


  /*
  3.Detect if there is a cycle in the list and return its starting point
  1->2->3->4->5->6->7->8->9->10
                    |         |
                    |---------|
                          ^
                       ^
  */
  public static Node findCycle(Node head) {
    if (head == null) return head;

    Node slow = head;
    Node fast = head.next;
    while (fast != null && fast.next != null) {
      if (fast == slow) break;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast == slow) {
      slow = head;
      while (slow != fast.next) {
        slow = slow.next;
        fast = fast.next;
      }
      return fast.next;
    } else {
      return null;
    }
  }

  /*
  ­4.Merge two sorted lists
  */
  public static Node mergeSortedLinkedList(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;

    int data;
    if (a.data < b.data) {
      data = a.data;
      a = a.next;
    } else {
      data = b.data;
      b = b.next;
    }

    Node result = new Node(data);
    Node curr = result;

    while (a != null || b != null) {
      if (a == null) {
        Node n = new Node(b.data);
        curr.next = n;
        b = b.next;
      } else if (b == null) {
        Node n = new Node(a.data);
        curr.next = n;
        a = a.next;
      } else if (a.data < b.data) {
        Node n = new Node(a.data);
        curr.next = n;
        a = a.next;
      } else {
        Node n = new Node(b.data);
        curr.next = n;
        b = b.next;
      }
      curr = curr.next;

    }

    return result;
  }

  /*
  ­5.Split a list into two lists one has even indexes other has odd indexes
    0->1->2->3->4->5->6-7->null
  e       ^
  o       ^
  */
  public static Node splitIndexes(Node head) {
    if (head == null) return null;
    Node evens = head;
    Node odds = head.next;
    Node headOdd = odds;

    while (evens != null && evens.next != null) {
      Node nextEven = evens.next;
      evens.next = nextEven.next;
      evens = evens.next;

      Node nextOdd = odds.next;
      if (nextOdd != null) {
        odds.next = nextOdd.next;
        odds = odds.next;
      }
    }

    return headOdd;
  }


  /*
  ­6.Find kth to last node
    0->1->2->3->4->5->6->7->null (3)
                            ^
                   ^
  */
  public static int findKthToLast(Node head, int k) {
    if (head == null) return -1;
    if (k <= 0) return -1;
    Node first = head;
    Node second = head;
    int i = 0;
    while (i < k) {
      if (first == null) return -1;
      first = first.next;
      i++;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    return second.data;
  }

  /*
  7.Delete all nodes with value k
      0->1->2->3->4->5->6->7->null
  c            ^
  p      ^
  */
  public static Node deleteAll(Node head, int e) {
    if (head == null) return null;
    Node curr = head;
    Node prev = null;

    while (curr != null) {
      if (curr.data == e) {
        Node next = curr.next;
        if (next != null) {
          curr.data = next.data;
          curr.next = next.next;
        } else {
          prev.next = null;
          break;
        }
      } else {
        prev = curr;
        curr = curr.next;
      }
    }
    return head;
  }

  /*
  8.Shuffles two list together
  {1,2,3,8,10,11};
  {4,5,6,7,13};
  */
  public static void shufflesThemTogether(Node a, Node b) {
    if (a == null) { a = b; return; }
    if (b == null) return;

    Node currA = a;
    Node currB = b;
    Node tempA;
    Node tempB;

    while (currA != null && currB != null) {
      tempA = currA.next;
      tempB = currB.next;
      currA.next = currB;
      currB.next = tempA;
      currA = tempA;
      currB = tempB;
    }
  }


  /*
  9.Array to linked list
  */
  public static Node arrayToLinkedList(int[] array) {
    Node prev = null;
    for (int i=array.length-1; i>=0; i--) {
      Node temp = new Node(array[i]);
      temp.next = prev;
      prev = temp;
    }
    return prev;
  }

  /*
  10.Remove kth to last node
  */
  public static void removeKthToLast(Node head, int k) {
    if (head == null) return;
    if (k <= 0) return;

    Node first = head;
    Node second = head;
    int i = 0;
    while (i < k) {
      if (first == null) return;
      first = first.next;
      i++;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }
    Node next = second.next;
    if (next == null) {
      second.next = null;
    } else {
      second.data = next.data;
      second.next = next.next;
    }
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;

    print(n1);
    printRecursive(n1);
    printRecursiveReversed(n1);
    System.out.println("");
    System.out.println("");

    System.out.println("1.Reverse a singly linked list");
    Node reversed = reverse(n1);
    print(reversed);
    n1 = reverse(reversed);
    System.out.println("");

    System.out.println("1.Reverse a singly linked list recursive");
    Node normal = reverseRecursive(n1);
    print(normal);
    n1 = reverse(reversed);

    System.out.println("");

    System.out.println("2.Delete a node in a linked list");
    delete(n1, n1);
    print(n1);
    System.out.println("");

    System.out.println("2.Insert a node last in a linked list");
    Node n7 = new Node(7);
    insertLast(n1, n7);
    print(n1);
    System.out.println("");

    System.out.println("2.Insert a node first in a linked list");
    Node n0 = new Node(1);
    insertFirst(n1, n0);
    print(n0);
    System.out.println("");

    System.out.println("3.Find cycle in the list and return its starting point");
    n7.next = n5;
    Node point = findCycle(n0);
    System.out.println(point.data);

    System.out.println("4.Merge two sorted lists");
    int[] arrayA = {1,2,3,8,10,11};
    int[] arrayB = {4,5,6,7,13};
    Node listA = arrayToLinkedList(arrayA);
    Node listB = arrayToLinkedList(arrayB);
    Node sorted = mergeSortedLinkedList(listA,listB);
    print(sorted);
    System.out.println("");

    System.out.println("5.Split a list into two lists one has even indexes other has odd indexes");
    int[] idx = {0,1,2,3,4,5,6,7,8,9};
    Node indexes = arrayToLinkedList(idx);
    Node odds = splitIndexes(indexes);
    print(indexes);
    print(odds);
    System.out.println("");

    System.out.println("­6.Find kth to last node");
    print(sorted);
    System.out.println(findKthToLast(sorted,7));
    System.out.println("");

    System.out.println("­7.Delete all nodes with value k");
    int[] toDelete = {6,6,6,6,5,6,8,10,6};
    Node before = arrayToLinkedList(toDelete);
    print(before);
    Node after = deleteAll(before,6);
    print(after);
    System.out.println("");

    System.out.println("8.Shuffles two list together");
    int[] sA = {1,2,3,8,10,11};
    int[] sB = {4,5,6,7,13};
    Node nA = arrayToLinkedList(sA);
    Node nB = arrayToLinkedList(sB);
    shufflesThemTogether(nA,nB);
    print(nA);
    System.out.println("");

    System.out.println("9.Array to linked list");
    int[] array = {1,2,3,4,5,6,8,10,11};
    Node linkedListArray = arrayToLinkedList(array);
    print(linkedListArray);
    System.out.println("");

    System.out.println("10.Remove kth to last node");
    print(linkedListArray);
    removeKthToLast(linkedListArray,3);
    print(linkedListArray);
    System.out.println("");

  }
}
