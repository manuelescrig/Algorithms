//
//  main.cpp
//  BiggestPalindrome
//
//  Created by Manuel Escrig on 1/12/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

void largestPal(string input_str);

int main ()
{
  
    string test("HYTBCABADEFGHABCDEDCBAGHTFYW123456789987654321ZWETYGDE");
    largestPal(test);
    
    return 0;
}

void largestPal(string input_str) {
    string isPal = "";
    string largest = "";
    int j, k;
    for(int i = 0; i < input_str.length() - 1; ++i)
    {
        k = i + 1;
        j = i - 1;
        
        // starting a new interation                                                      
        // check to see if even pal                                                       
        if(j >= 0 && k < input_str.length()) {
            if(input_str[i] == input_str[j])
                j--;
            else if(input_str[i] == input_str[j]) {
                k++;
            }
        }
        while(j >= 0 && k < input_str.length())
        {
            if(input_str[j] != input_str[k])
                break;
            else
            {
                j--;
                k++;
            }
            isPal = input_str.substr(j + 1, k - j - 1);
            if(isPal.length() > largest.length()) {
                largest = isPal;
            }
        }
    }
    cout << "Largest: "  << largest << endl;
}
