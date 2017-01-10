import java.util.*;
import java.lang.*;
import java.io.*;
/*
*/
class BuildOrder {

  public static List<Integer> buildOrder(int[][] processes) {
    Set<Integer> tempMarks = new HashSet<Integer>();
    Set<Integer> permMarks = new HashSet<Integer>();
    List<Integer> result = new LinkedList<Integer>();

    for (int i=0; i<processes.length; i++) {
      if(permMarks.contains(i)){
        visit(i, processes, tempMarks,permMarks, result);
      }
    }
    return result;
  }

  public static void visit( int process,
                            int[][] processes,
                            Set<Integer> tempMarks,
                            Set<Integer> permMarks,
                            List<Integer> results) {

    if (tempMarks.contains(process)) {
      thrown new runtimeExpection();
    }
    if (!permMarks.contains(process)) {
      tempMarks.add(process);
      for (int i : processes[process]) {
        visit(i,processes,tempMarks,permMarks,results);
      }
      permMarks.add(process);
      tempMarks.remove(process);
      results.add(process);
    }
  }

  public static void main (String[] args) {
  }
}