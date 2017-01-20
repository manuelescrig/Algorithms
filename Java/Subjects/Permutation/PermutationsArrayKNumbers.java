import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a list of n distinct elements and a number k,
write a function that lists all k­element permutations of that list.
k = 2;
{1,2} => {1,2} {2,1}
{1,2,3} => {1,2} {2,1} {1,3} {3,1} {2,3} {3,2}
{1,2,3,4} => {1,2} {2,1} {1,3} {3,1} {1,4} {4,1} {2,3} {3,2} {2,4} {4,2} {3,4} {4,3}

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

class PermutationsArrayKNumbers {

  public static void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
    if (temp.size() == nums.length) {
      list.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i<nums.length; i++) {
        if (temp.contains(nums[i])) continue; // element already exists, skip
        temp.add(nums[i]);
        backTrack(list, temp, nums, i+1);
        temp.remove(temp.size()-1);
      }
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    backTrack(list, new LinkedList<Integer>(),nums, 0);
    return list;
  }

  public static void print(int[] set) {
    System.out.print("[");
    for (int i=0; i<set.length-1; i++) {
      System.out.print(set[i] + ",");
    }
    System.out.print(set[set.length-1]+"]");
  }

  public static void main (String[] args) {
    //int[] elements = {1,2,3,4,5};
    int[] elements = {1,2,3};
    List<List<Integer>> result = permute(elements);
    System.out.println(result.toString());
  }
}
