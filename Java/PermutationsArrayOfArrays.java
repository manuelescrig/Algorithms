import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a list of array, return a list of arrays,
each array is a combination of one element in each given array.

input = [[1, 2, 3], [4], [5, 6]]
output = [[1, 4, 5], [1, 4, 6], [2, 4, 5], [2, 4, 6], [3, 4, 5], [3, 4, 6]]

1,2,3  4  5,6

1,4,5  1,4,6  2,4,5  2,4,6  3,4,5  3,4,6

0 			0			 1   		1			 2			2
0			0			 0			0			 0			0
0			1			 0			1			 0			1
*/

class PermutationsArrayOfArrays {

	public static ArrayList<ArrayList<Integer>> arrayOfArrays(ArrayList<ArrayList<Integer>> input) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int[] indexes = new int[input.size()];
		permutations(result, input, indexes);
		return result;
	}

	public static void permutations(ArrayList<ArrayList<Integer>> result,
																	ArrayList<ArrayList<Integer>> input,
																	int[] indexes) {
		// Finished
		if (indexes[0] == input.get(0).size()) return;

		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i=0; i<indexes.length; i++) {
				temp.add(input.get(i).get(indexes[i]));
		}
		
		result.add(temp);

		// Increment
		indexes[input.size()-1]++;
		for (int i=input.size()-1; i>0; i--) {
			System.out.println("i:" + i);
			if (indexes[i] == input.get(i).size()) {
				indexes[i] = 0;
				indexes[i-1]++;
			}
		}
		permutations(result,input,indexes);
	}


	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);

		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(6);
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(list1);
		input.add(list2);
		input.add(list3);

		ArrayList<ArrayList<Integer>> output = arrayOfArrays(input);
		System.out.println(output.toString());
	}

}
