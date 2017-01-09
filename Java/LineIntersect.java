import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given two lines, write a function to determine whether or not they
intersect.

y = mx + b;

*/
class LineIntersect {

  public static class Line {
    private static double epsilon = 0.00001;
    private double slope;
    private double yIntercept;
    public Line (double slope, double yIntercept) {
      this.slope = slope;
      this.yIntercept = yIntercept;
    }

    public boolean intersect(Line line) {
      if (this.equals(line)) return true;
      if (Math.abs(slope - line.slope) < epsilon) return true;
      return false;
    }

    @Override
    public boolean equals(Object o) {
      if(!(o instanceof Line)) return false;
      Line line = (Line) o;
      return Math.abs(slope - line.slope) < epsilon &&
             Math.abs(yIntercept - line.yIntercept) < epsilon;
    }

  }

  public static void main (String[] args) {
      Line a = new Line(0, 2);
      Line b = new Line(0, 2);

      System.out.println(a.intersect(b));
  }

}
