import java.util.*;
import java.lang.*;
import java.io.*;

/*
Clone an undirected graph. Each node in the graph contains a label and a
list of its neighbors.
*/

class GraphClone {
  public static class GraphNode {
    int value;
    ArrayList<GraphNode> neighbors;
    boolean visited;
    public GraphNode(int value) {
      this.value = value;
    }
  }

  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) return null;

    Queue<GraphNode> queue = new LinkedList<GraphNode>();
    HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode,GraphNode>();
    GraphNode newHead = new GraphNode(node.value);
    queue.add(node);
    map.add(node, newHead);
    while (!queue.isEmpty()) {
      GraphNode curr = queue.remove();
      ArrayList<GraphNode> currNeighbors = curr.neighbors;

      for (GraphNode neighbor : currNeighbors) {
        if (!map.containsKey(neighbor)) {
          GraphNode copy = new GraphNode(neighbor.value);
          map.put(neighbor,copy);
          map.get(curr).neighbors.add(copy);
          queue.add(neighbor);
        } else {
          map.get(curr).neighbors.add(map.get(neighbor));
        }
      }
    }
    return newHead;
  }

  public static void main (String[] args) {


  }
}
