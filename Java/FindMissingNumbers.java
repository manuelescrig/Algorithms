import java.util.*;
import java.lang.*;
import java.io.*;
/*

Examples:
[] “0-99”
[0] “1-99”
[3, 5] “0-2,4,6-99”
[0, 1, 2, 50, 52, 75] "3-49,51,53-74,76-99"

*/

class FindMissingNumbers {
  public static void main (String[] args) {

    int[] array = {0,1,2,50,52,75,98};
    StringBuilder result = new StringBuilder();
    int lastValue = -1;
    for (int i=0; i< array.length; i++) {

      if (i == 0 && array[i] != 0) {
        int value = --array[i];
        value--;
        if (value != 0) result.append("0-");
        result.append(value+",");
        lastValue = array[i];
      }

      if (array[i] - lastValue == 1) {
        lastValue = array[i];
      } else if (array[i] - lastValue == 2) {
        int value = array[i];
        value--;
        result.append(value+",");
        lastValue = array[i];
      } else if (array[i] - lastValue > 2) {
        lastValue++;
        int value = array[i];
        value--;
        result.append(lastValue+"-"+value+",");
        lastValue = array[i];
      }
    }

    if (lastValue != 99) {
      lastValue++;
      if (lastValue != 99) result.append(lastValue+"-99");
      else result.append("99");
    }
    System.out.println(result);
  }
}
