import java.util.*;
import java.lang.*;
import java.io.*;

/*
Write a function that returns all permutations of a given list.
Input:
{1,2,3}
Output:
{1,2,3}
{1,3,2}
{2,1,3}
{2,3,1}
{3,1,2}
{3,2,1}

Input:
{1,2}
Output:
{1,2}
{2,1}
*/

class PermutationsNumbers {

	public static ArrayList<int[]> permutationsVector(int[] a) {
		ArrayList<int[]> result = new ArrayList<int[]>();
		permutateVector(0,a,result);
		return result;
	}

	public static void permutateVector(int n, int[] a, ArrayList<int[]> result) {
		if (n == a.length-1) {
			result.add(a.clone());
		} else {
			for (int i=n; i< a.length; i++) {
				swap(a, n, i);
				for (int x : a) {
					 System.out.print(x+","+i+","+n+" ");
				 }
				System.out.println(" ");
				permutateVector(n+1, a, result);
				swap(a, n, i);
			}
		}
	}

	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		permutate(empty,list,result);
		return result;
	}

	private static void permutate(ArrayList<Integer> prefix,
																ArrayList<Integer> suffix,
																ArrayList<ArrayList<Integer>> result) {
    if (suffix.size() == 0) {
	    result.add(prefix);
		} else {
			for (int i=0; i<suffix.size(); i++) {
				ArrayList<Integer> pre = new ArrayList<Integer>();
				ArrayList<Integer> suf = new ArrayList<Integer>();
				pre.addAll(prefix);
				pre.add(suffix.get(i));
				suf.addAll(suffix.subList(0,i));
				suf.addAll(suffix.subList(i+1,suffix.size()));
				permutate(pre, suf, result);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(3);
		System.out.println(array.toString());

		ArrayList<ArrayList<Integer>> result = permutations(array);
		System.out.println(result.toString());

		int[] a = {1,2,3};
		ArrayList<int[]> vectors = permutationsVector(a);
		// for (int[] v : vectors) {
		// 	for (int i : v) {
		// 		System.out.print(i+" ");
		// 	}
		// 	System.out.println(" ");
		// }
	}
}
