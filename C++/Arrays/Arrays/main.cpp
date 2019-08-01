//
//  main.cpp
//  Arrays
//
//  Created by Manuel Escrig on 1/12/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>

using namespace std;

// 5) In an array 1-100 numbers are stored, one number is missing how do you find it?
void missingNumber();

// 6) In an array 1-100 exactly one number is duplicate how do you find it?
void find_duplicate(int * data, int data_size, int l_limit, int u_limit);

// 7) In an array 1-100 many numbers are duplicates, how do you find it?
void duplicateNumber();

// 8) Given two arrays, 1,2,3,4,5 and 2,3,1,0,5 find which number is not present in the second array.
void notInSecondArray();

// 9) How do you find second highest number in an integer array?
void findSecondHighest();

// X) Find two numbers in an array whose sum equals to X
bool isTwoSumEq(int * data, int size, int target);

// X) Print Union of Two arrays
void printUnion();

// X) Print Intersection of Two arrays
void printIntersection();

// ---------------------

// X) Reverse Array
char *revstr(char *);

// X) Find out the maximum distance between two non-zero values in an array

// X) Find out the number which has maximum ocurrance in  an array

// X) Find out whether in a character string, number of openbraces is the same of number of closedbraces  or not

// X) strcmp related

// X) distinct pairs present in an array

// X) Calculate how many numbers between a and b are divisible by k

// X) Counting inversions in an array

// X) Given an array A return the minimum number of transformation (*) steps necessary to make all elements in the array equal. 
void minimunStepsForEqualArray() {
    
    int array [] = { 11, 3, 7, 1};
    int num_elements = sizeof( array ) / sizeof( array[0] );
    cout << "Elements: " << num_elements << endl;
    
    
    int min = array[0]; int max = array[0];

    for (int i = 1; i < num_elements; i++)
    {
        if (array[i] % 2 != min % 2) cerr << "Error" << endl;
        if (array[i] < min) min = array[i];
        if (array[i] > max) max = array[i]; 
    }
    
    int goal = (max + min) / 2;
    int count = (max - min) / 2;

    for (int i = min; i < goal; i++)
    {
        for (int k = 0; k < count; k++)
            if (array[k] < goal) array[k]++;
            else
                array[k]--; 
    }   
    cout << "Steps: "  << (max - min) / 2 << endl;
}

// X) Equi point of an array
void equi () {
    int array [] = { 1, 2, 3, 4, 5, 6, 0, 8, 9};
    int num_elements = sizeof( array ) / sizeof( array[0] );
    cout << "Elements: " << num_elements << endl;

    int equi = -1;
    
    long lower = 0;
    long upper = 0;
    for (int i=0; i< num_elements;i++) {
        upper += i;
        cout << upper << "-";
    }
    cout << endl;
    
    for (int i = 0; i < num_elements; i++) {
        upper -= array[i];
        cout << upper << "*";
        if (upper == lower)
        {
            equi = i;
            break;
        }
        else
            lower += array[i];
    }
    cout << endl;
    cout << "Equi: " << equi << endl;
}


int main (int argc, const char * argv[])
{

    // 5) In an array 1-100 numbers are stored, one number is missing how do you find it?
    //missingNumber();
    
    // 6) In an array 1-100 exactly one number is duplicate how do you find it?
    //int array [] = { 1, 2, 3, 4, 5, 6, 6, 8, 9, 10};
    //int num_elements = sizeof( array ) / sizeof( array[0] );
    //cout << "Elements: " << num_elements << endl;
    //int l_limit = 0;
    //int u_limit = 10;
    //find_duplicate(array,num_elements, l_limit, u_limit);
    
    // 7) In an array 1-100 many numbers are duplicates, how do you find it?
    //duplicateNumber();
    
    // 8) Given two arrays, 1,2,3,4,5 and 2,3,1,0,5 find which number is not present in the second array.
    //notInSecondArray();
    
    // 9) How do you find second highest number in an integer array?
    //findSecondHighest();
    
    // X) Find two numbers in an array whose sum equals to X
    //bool isTwoSumEq(data, size, target);
    
    // X) Print Unio of Two arrays
    //printUnion();
    
    // X) Print Intersection of Two arrays
    //printIntersection();
    
    // X) Given an array A return the minimum number of transformation (*) steps necessary to make all elements in the array equal. 
    //minimunStepsForEqualArray();

    // X) Equi point of an array
    equi();
        
    return 0;
}


// 5) In an array 1-100 numbers are stored, one number is missing how do you find it?
void missingNumber() {
    
    int array [] = { 1, 2, 3, 4, 5, 6, 0, 8, 9};
    int num_elements = sizeof( array ) / sizeof( array[0] );
    cout << "Elements: " << num_elements << endl;
    
    // will be the sum of the numbers in the array.
    int sum = 0;
    int idx = -1;
    for (int i = 0; i < num_elements; i++) {
        if (array[i] == 0) {
            idx = i; 
        } else {
            sum += array[i];
        }
    }
    cout << "Sum: " << sum << endl;
    
    // the total sum of numbers between 1 and arr.length.
    int total = (num_elements + 1) * num_elements  / 2;
    
    cout << " Missing number is: " << (total - sum) << " at index " << idx << endl;
}



// 6) In an array 1-100 exactly one number is duplicate how do you find it?
void find_duplicate(int * data, int data_size, int l_limit, int u_limit){
    
    if(l_limit >= u_limit){
        cerr << "u_limit should be larger than l_limit" << endl;
    }
    
    int s_limit = u_limit - l_limit + 1;
    
    bool * mark = new bool[s_limit];
    for (int i=0; i<s_limit; i++){  mark[i] = false;  }
    
    for (int i=0; i< data_size; i++){ 
        cout << i << endl;
        if(mark[data[i]-l_limit]==true){
            delete [] mark;
            cout << "Duplicate: " << data[i] << endl;
        }else{
            mark[data[i]-l_limit]=true; 
        }
    }
    cout << "Not duplicate" << endl;
}


// 7) In an array 1-100 many numbers are duplicates, how do you find it?
void duplicateNumber() {
    
    int array [] = { 1, 2, 3, 4, 5, 6, 6, 8, 9, 10, 10};
    int num_elements = sizeof( array ) / sizeof( array[0] );
    cout << "Elements: " << num_elements << endl;
    
    for (int i = 0; i < num_elements; ++i) {
        if (array[i] != i && array[array[i]] == array[i]) {
            cout << array[i]<< endl;
            array[array[i]] = i;
        }
    }
    
}

// 8) Not in the second array
void notInSecondArray(){
    int arrayA[] = { 1, 2, 3, 4, 5};
    int num_elementsA = sizeof( arrayA ) / sizeof( arrayA[0] );
    cout << "Elements: " << num_elementsA << endl;
    
    int arrayB[] = { 2, 3, 1, 0, 5};
    int num_elementsB = sizeof( arrayB ) / sizeof( arrayB[0] );
    cout << "Elements: " << num_elementsB << endl;
    
    // Sort the second array;
    sort(arrayB,arrayB+5);
    for (int i=0; i < num_elementsB; i++) {
        cout <<  arrayB[i];
    }
    cout << endl;
    
    // Binary Search 
    for (int i=0; i < num_elementsA; i++) {
        if (binary_search (arrayB, arrayB+num_elementsB,arrayA[i])) 
            cout << arrayA[i] << " found!\n"; else cout << arrayA[i] << " not found.\n";
    }
}

// 9) How do you find second highest number in an integer array?
void findSecondHighest() {
    int array[]={1,8,5,7,10,9,2};
    int firstmax=array[0];
    int secondmax=array[1];
    int temp;
    if(firstmax<secondmax)
    {
        temp=secondmax;
        secondmax=firstmax;
        firstmax=temp;
    }
    
    for(int i=0;i<7;i++)
    {
        if(firstmax<array[i])
        {
            secondmax=firstmax;
            firstmax=array[i];
        }
        if((firstmax>array[i])&&(array[i]>secondmax))
        {
            secondmax=array[i];
        }
    }
    printf("second max:%d\n",secondmax);
}


// X) Find two numbers in an array whose sum equals to X
bool isTwoSumEq(int * data, int size, int target){
    if(size<2){
        return false;
    }
    // 1> Sort the data from small to large.                                                          
    sort(data, data+size);
    
    // 2> Use a head-tail technique to find the result.
    
    int head = 0, tail = size-1;
    int cSum;
    do{
        //    (a) First let head points to the first element of the sorted array and
        //    the tail points to the last element of the sorted array.
        cSum = data[head]+data[tail];
        
        //    (b) Check the sum of head and tail
        if(cSum == target){
            //    (c) If the sum is equal to target, then return true
            cout << "data[" << head << "]:=" << data[head] << endl;
            cout << "data[" << tail << "]:=" << data[tail] << endl;
            cout << "cSum: " << cSum << endl;
            return true;
        }else{
            if(cSum<target){
                //    (d) If the sum is less than the target, then move the head one step right
                head++;
            }else{
                //    (e) If the sum is larger than the target, then move the tail one step left
                tail--;
            }
        }
    }while(head<tail);
    //    (f) If head>=tail, then we search all the elements in the array.
    //        No two numbers in the array whose sum equals to target 
    return false;
}

// X) Print Unio of Two arrays
void printUnion(){
    int arr1[] = {1, 2, 4, 5, 6};
    int arr2[] = {2, 3, 5, 7};
    int m = sizeof(arr1)/sizeof(arr1[0]);
    int n = sizeof(arr2)/sizeof(arr2[0]);
    
    int i = 0, j = 0;
    while(i < m && j < n)
    {
        if(arr1[i] < arr2[j])
            printf(" %d ", arr1[i++]);
        else if(arr2[j] < arr1[i])
            printf(" %d ", arr2[j++]);
        else
        {
            printf(" %d ", arr2[j++]);
            i++;
        }
    }
    
    /* Print remaining elements of the larger array */
    while(i < m)
        printf(" %d ", arr1[i++]);
    while(j < n)
        printf(" %d ", arr2[j++]);
}

// X) Print Intersection of Two arrays
void printIntersection(){
    
    int arr1[] = {1, 2, 4, 5, 6};
    int arr2[] = {2, 3, 5, 7};
    int m = sizeof(arr1)/sizeof(arr1[0]);
    int n = sizeof(arr2)/sizeof(arr2[0]);
    int i = 0, j = 0;
    while(i < m && j < n)
    {
        if(arr1[i] < arr2[j])
            i++;
        else if(arr2[j] < arr1[i])
            j++;
        else /* if arr1[i] == arr2[j] */
        {
            printf(" %d ", arr2[j++]);
            i++;
        }
    }
}