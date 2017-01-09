import java.util.*;
import java.lang.*;
import java.io.*;
/*
Write a function that returns all permutations of a given string.

*/

class PermutationsStrings {

	public static ArrayList<String> permutations(String s) {
		ArrayList<String> result = new ArrayList<String>();
		permutate("", s, result);
		return result;
	}

	private static void permutate(String prefix, String suffix, ArrayList<String>result) {
		if (suffix.length() == 0) {
			result.add(prefix);
			return;
		} else {
			for (int i=0; i<suffix.length(); i++) {
				String pre = prefix + suffix.charAt(i);
				String suf = suffix.substring(0,i) + suffix.substring(i+1);
				permutate(pre,suf,result);
			}
		}
	}

	public static void main(String[] args) {
		String s= "abc";
		ArrayList<String> result = permutations(s);
		System.out.println(result.toString());
	}

}
