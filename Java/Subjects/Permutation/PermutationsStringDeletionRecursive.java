import java.util.*;
import java.lang.*;
import java.io.*;

/*
abcdefg
acg
bef
a
adeg


abc
bc

abc
i = 0;
i = 1;
abc
bc
0, 1 = a
1, 3 = bc
b c = bc

n * (n-1) * (n-2) * …

n^n
n!

ABCD
A = "" "A" = 2
AB "", A, B, AB = 4
ABC "", A, B, C, AB, AC, BC, ABC = 8
ABCD = 16
0b0000
0b0001
2^n
*/

class PermutationsStringDeletionRecursive {

	public static String findWord(String input, HashSet<String> dict) {
		if (input.length() == 0) return null;
		if (dict.contains(input)) return input;

		String max = "";
		for (int i = 0; i<input.length(); i++) {
			String temp = input.substring(0,i) + input.substring(i+1,input.length());
			System.out.println(temp + "," + max);
			String result = findWord(temp, dict);
			if (result != null) {
				if (result.length() > max.length() ) max = result;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "google";
		HashSet<String> set = new HashSet<String>();
		set.add("gle");

		String result = findWord(s,set);
		System.out.println(result);
	}
}
