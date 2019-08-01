//
//  main.cpp
//  Search
//
//  Created by Manuel Escrig on 1/10/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include <stdlib.h>

const int NUM_PRODUCTS = 32768;
const int LOW_VALUE = 0;
const int FAILURE = -1;

int linearSearch(int arr[], int target);
int binarySearch(int arr[], int target);


int main (int argc, const char * argv[])
{

    // insert code here...
    std::cout << "Hello, Search!\n";
    return 0;
}

// linear search defined for integer arrays
int linearSearch(int arr[], int target)
{
    int position = 0;
    int result = -1;
    
    while (result == -1 && position < NUM_PRODUCTS)
    {
        if (arr[position] == target)
        {
            result = position;     // target position
        }
        position++;
    }
    return result;
}

// binary search defined for integer arrays previously sorting in ascending order
int binarySearch(int arr[], int target)
{
    int middlePosition;
    int middleValue;
    int result = -1;
    int low = 0;
    int high = NUM_PRODUCTS - 1;
    
    while (result == -1 && low <= high)
    {
        middlePosition = (low + high) / 2;
        middleValue = arr[middlePosition];
        if (target == middleValue)
        {
            result = middlePosition;
        }
        else if (target < middleValue)
            high = middlePosition - 1;
        else
            low = middlePosition + 1;
    }
    return result;
}