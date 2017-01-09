import java.util.*;
import java.lang.*;
import java.io.*;
/*
1.Find the number of ones in the binary representation of a number.
2.Write a function to sum two numbers
3.Rotate bits
4.Gray Code
*/

class Chapter_5_Bits {

  // 1.Find the number of ones in the binary representation of a number.
  public static int ones(int x) {
    int sum = 0;
    while (x > 0) {
      sum += x ^ 1;
      x >>= 1;
    }
    return sum;
  }

  // 2.Write a function to sum two numbers.
  public static int sum(int x, int y) {
    if (y == 0) return x;
    int partial = x ^ y;
    int carry = (x & y) << 1;
    return sum(partial, carry);
  }

  // 3. Rotate bits. Given a number, write a function to rotate the bits
  // ie circular array
  // rotate(0xFFFF0000, 8) => 0x00FFFFF00
  // - Rotating to the right or to the left?
  // -
  public static int rotate(int number, int rotations) {

    int reminder = number << (32 - rotations);
    int result = number >> rotations;
    result = reminder | result;
    return result;
  }


  // 4. Gray Code. Given two integers, determine wheter or not they differ
  // by a single bit.
  // eg.
  // gray(0,1) = true;
  // gray(1,2) = false;
  // 0b01010101,0b01010100 = true
  // 0b01010111,0b01010100 = false
  public static boolean grayNumber(int x, int y) {
    int value = x^y;
    int ones = 0;
    while (value > 0) {
      ones += value ^ 1;
      value >>= 1;
    }

    System.out.println(ones);
    if (ones <= 1) return true;
    else return false;
  }

  public static void main(String args[]) {

    System.out.println(grayNumber(0,1));
    System.out.println("---");

    System.out.println(grayNumber(1,2));
    System.out.println("---");

    System.out.println(grayNumber(0,2));
    System.out.println("---");


    System.out.println(rotate(0xFFFF0000,8));
    System.out.println("---");

    int x = 13;
    int y = 9;
    int result = x + y;
    System.out.println(result);
    System.out.println(sum(x,y));

    System.out.println("---");


    System.out.println(ones(2));
    System.out.println(ones(3));
    System.out.println(ones(5));
    System.out.println(ones(7));

    int a = 60;	/* 60 = 0011 1100 */
    int b = 13;	/* 13 = 0000 1101 */
    int c = 0;

    c = a & b;        /* 12 = 0000 1100 */
    System.out.println("a & b = " + c );

    c = a | b;        /* 61 = 0011 1101 */
    System.out.println("a | b = " + c );

    c = a ^ b;        /* 49 = 0011 0001 */
    System.out.println("a ^ b = " + c );

    c = ~a;           /*-61 = 1100 0011 */
    System.out.println("~a = " + c );

    c = a << 2;       /* 240 = 1111 0000 */
    System.out.println("a << 2 = " + c );

    c = a >> 2;       /* 15 = 1111 */
    System.out.println("a >> 2  = " + c );

    c = a >>> 2;      /* 15 = 0000 1111 */
    System.out.println("a >>> 2 = " + c );
  }
}
