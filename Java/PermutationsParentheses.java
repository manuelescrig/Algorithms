import java.util.*;
import java.lang.*;
import java.io.*;
/*
n = 1 => "()"
n = 2 => “(())” and “()()”
n = 3 => “((()))”, “(()())”, “(())()”, “()(())”, “()()()”
*/

class PermutationsParentheses {
  //now let's create a test case
	public static void main(String[] args) {
		printParenthesis(2,2,"");
	}

	public static void printParenthesis(int left, int right, String result) {
		if (right==0) {
			System.out.println(result);
			return;
		}
		if (left>0) {
			printParenthesis(left-1, right, result+"(");
			if (left < right)
				printParenthesis(left, right-1, result+")");
		}	else {
			printParenthesis(left, right-1, result+")");
    }
  }
}
