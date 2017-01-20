import java.util.*;
import java.lang.*;
import java.io.*;

/*
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class PermutationsArraySubsetsDuplicates {
  public static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
      if (i > start && nums[i] == nums[i-1]) continue;
      tempList.add(nums[i]);
      backtrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> list = new ArrayList();
      Arrays.sort(nums);
      backtrack(list, new LinkedList<Integer>(), nums, 0);
      return list;
  }

  public static void main (String[] args) {
    int[] elements = {1,2,3,4};
    List<List<Integer>> result = subsetsWithDup(elements);
    System.out.println(result.toString());
  }
}
