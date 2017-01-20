import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given a list of Strings, write a function to find the kth most frequently
recurring string.
*/

class StringKthRepeated {

  // Option A
  public static String kthMostFrequentA(ArrayList<String> input, int k) {
    // Count String frequencies in a HashMap
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String s : input) {
      if (!map.containsKey(s)) {
        map.put(s,1);
      } else {
        int value = map.get(s);
        map.put(s,++value);
      }
    }

    int maxValue = Integer.MIN_VALUE;
    String maxKey = "";

    // Iterate from i to k
    for (int i=0; i<k; i++) {
      System.out.println(i);
      maxValue = Integer.MIN_VALUE;
      maxKey = "";

      // Check the most repeated
      for (String key : map.keySet()) {
        int value = map.get(key);
        if (value > maxValue) {
          maxValue = value;
          maxKey = key;
        }
      }
      // Remove current key
      map.remove(maxKey);
    }
    return maxKey;
  }

  // Option B
  public static String kthMostFrequent(ArrayList<String> input, int k) {
    // Count String frequencies in a HashMap
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String s : input) {
      if (!map.containsKey(s)) {
        map.put(s,1);
      } else {
        int value = map.get(s);
        map.put(s,++value);
      }
    }

    // Create an ArrayList from the HashMap and sort
    List<Map.Entry> list = new ArrayList(map.entrySet());
    Collections.sort(list, new Comparator() {
      public int compare(Object o1, Object o2) {
        Integer v1 = (Integer) ((Map.Entry) o1).getValue();
        Integer v2 = (Integer) ((Map.Entry) o2).getValue();
        return v1.compareTo(v2);
      }
    });

    // Return the k value
    if (list.size() > k) {
      return (String) list.get(k-1).getKey();
    } else {
      return "";
    }
  }

  public static void main (String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("b");
    list.add("b");
    System.out.println(kthMostFrequent(list,2));
  }
}
