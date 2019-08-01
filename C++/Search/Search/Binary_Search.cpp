//
//  Binary_Search.cpp
//  Search
//
//  Created by Manuel Escrig on 1/10/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>


int binarySearch(int arr[], int size, int target)
{
	int middlePosition;
	int middleValue;
	int result = -1;
	int low = 0;
	int high = size - 1;
    
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
