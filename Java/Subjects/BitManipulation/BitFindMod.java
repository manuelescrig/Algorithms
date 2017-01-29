import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given list of bytes a, each representing one byte of a larget integer
and an integer b, find a % b.
Eg. {0x12, 0x34, 0x56, 0x78} represents 0x12345678
Eg. mod({0x03, 0xED}, 10) = 0x03ED = 1005 % 10 = 10
*/

class BitFindMod {

  public static int mod(byte[] a, int b) {
    int m = 0;
    for (int i=0; i<a.length; i++) {
      m <<= 8; // m+=8
      m += (a[i] & 0xFF);
      m %= b;
    }
    return m;
  }

  public static void main (String[] args) {
    byte[] a = {(byte)0x03, (byte)0xED};
    int b = 10;
    System.out.println(mod(a,b));
  }
}
