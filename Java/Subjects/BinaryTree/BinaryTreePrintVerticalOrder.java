import java.util.*;
import java.lang.*;
import java.io.*;

/*
Print a binary tree in vertical order
              1(0)
            /     \
        2(-1)     3(1)
        /   \     /   \
    4(-2)  5(0) 6(0)  7(2)
                  \     \
                  8(1)  9(3)

The output of printing this tree vertically will be:
4
2
1 5 6
3 8
7
9

// top->down
// left -> right
[4]-[2]-[1,5,6]-[3,8]-[7]-[9]
*/

class BinaryTreePrintVerticalOrder {

  static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
      this.data = data;
    }
  }

  public static

  public static void preOrder(HashMap<Node, Integer> map, Node root, Integer n) {
      if (root == null) return;

      if (!map.containsKey(n)) {
          map.put(root, n);
      }

      preOrder(map, root.left,  n-1);
      preOrder(map, root.right, n+1);
  }

  public static void postOrder(HashMap<Node,Integer> prevMap,
                        HashMap<Integer, ArrayList<Node>> map,
                        Node root ) {
      if (root == null) return;

      postOrder(prevMap, map, root.left);
      postOrder(prevMap, map, root.right);

      int key = prevMap.get(root);
      if (!map.containsKey(key)) {
          ArrayList<Node> list = new ArrayList<Node>();
          list.add(root);
          map.put(key, list);
      } else {
          ArrayList<Node> list = map.get(key);
          list.add(root);
          map.put(key, list);
      }
  }

  public static void printVerticalOrder(Node root) {
      HashMap<Node, Integer> map = new HashMap<Node, Integer>();
      preOrder(map, root, 0);
      HashMap<Integer, ArrayList<Node>> postOrderMap = new HashMap<Integer, ArrayList<Node>>();
      postOrder(map, postOrderMap, root);

      int minKey = Integer.MAX_VALUE;
      for (Integer key : postOrderMap.keySet()) {
          if (key < minKey) minKey = key;
      }

      while (postOrderMap.containsKey(minKey)) {

          ArrayList<Node> list = postOrderMap.get(minKey);
          for (int i=list.size()-1; i>=0; i--) {
              Node n = list.get(i);
              System.out.print(n.data + " ");
          }
          System.out.println(" ");
          minKey++;
      }
  }

  public static void main (String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;
    n6.right = n8;
    n7.right = n9;

    printVerticalOrder(n1);
  }
}
