import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a directed graph, find the shortest path between two nodes.
*/

class ShortestPath {

  private static class Node {
    List<Node> next;
  }

  public List<Node> shortestPath(Node a, Node b) {
    if (a == null || b == null) return null;

    HashMap<Node, Node> parents = new HashMap<Node, Node>();
    Queue<Node> toVisit = new LinkedList<Node>();
    toVisit.add(a);
    parents.put(a,null);

    // BFS
    while (!toVisit.isEmpty()) {
      Node curr = toVisit.remove();
      if (curr == b) break;

      for (Node n = curr.next) {
        toVisit.add(n);
        parents.add(n, curr);
      }
    }

    // Build path
    if (parents.get(b) == null) return null;
    List<Node> result = new LinkedList<Node>();
    Node curr = b;
    while (curr != null) {
      result.add(0,curr);
      curr = parents.get(curr);
    }
    return result;
  }

  public static void main (String[] args) {

  }
}
