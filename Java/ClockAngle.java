import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given two integers, an hour and a minute, write a function to calculate the
angle between the two hands on a clock representing that time.
eg.
angle(11,10) -> 85º
*/
class ClockAngle {

  public static final double RADIUS = 360;
  public static final double MINUTES = 60;
  public static final double HOURS = 24;
  public static final double HOURS_IN_CLOCK = 12;

  public static double clockAngle(double hour, double min) {
    if (min < 0 || min > 60 || hour < 0 || hour > 24) {
      throw new IndexOutOfBoundsException("");
    }
    double h = convert(hour);
    double mAngle = RADIUS/MINUTES;
    double mTotal = min * mAngle;
    double hTotal = 0;
    if (h !=0 || h != 24) {
      hTotal = h * (5*mAngle);
    }
    System.out.println("hTotal:"+hTotal);
    hTotal += min * (RADIUS/MINUTES/HOURS_IN_CLOCK);
    System.out.println("hTotal:"+hTotal);
    System.out.println("mTotal:"+mTotal);

    double angle = hTotal - mTotal;
    if (angle < (RADIUS/2)) return angle;
    else return RADIUS - angle;
  }

  public static double convert(double hour) {
    if (hour > 12 ) return hour - 12;
    else return hour;
  }

  public static void main (String[] args) {
    System.out.println(clockAngle(11,10));
    System.out.println(clockAngle(10,52));
    System.out.println(clockAngle(12,15));
  }
}
