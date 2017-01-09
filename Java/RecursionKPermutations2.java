import java.util.*;
import java.lang.*;
import java.io.*;
/*
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class RecursionKPermutations2 {
  public static void backTrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, boolean[] used) {
    if (temp.size() == nums.length) {
      list.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i<nums.length; i++) {
        if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
        temp.add(nums[i]);
        used[i] = true;
        backTrack(list, temp, nums, used);
        used[i] = false;
        temp.remove(temp.size()-1);
      }
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    Arrays.sort(nums);
    backTrack(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
    return list;
  }

  public static void main (String[] args) {
    //int[] elements = {1,2,3,4,5};
    int[] elements = {1,1,2};
    List<List<Integer>> result = permute(elements);
    System.out.println(result.toString());
  }

  public static void print(int[] set) {
    System.out.print("[");
    for (int i=0; i<set.length-1; i++) {
      System.out.print(set[i] + ",");
    }
    System.out.print(set[set.length-1]+"]");
  }
}
