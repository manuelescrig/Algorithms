//
//  Sequential_Search.cpp
//  Search
//
//  Created by Manuel Escrig on 1/10/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>

int linearSearch(int arr[], int size, int target)
{
    int position = 0;
    int result = -1;
    
    while (result == -1 && position < size)
    {
        if (arr[position] == target)
        {
            result = position;	// target position
        }
        position++;
    }
    return result;
}

