//
//  main.cpp
//  Sorting
//
//  Created by Manuel Escrig on 1/12/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>
using namespace std;


// 17) Write a program to sort numbers using quick sort?
void exch(int a[],int i,int j){
    int s=a[i];
    a[i]=a[j];
    a[j]=s;    
}

int  partition(int a[],int l,int h);

void quick(int a[],int l,int h){
    if (h<=l) return ;
    int j=partition(a,l,h);
    quick(a,l,j-1);
    quick(a,j+1,h);
}
int partition(int a[],int l,int h){

    int i=l-1;
    int j=h;
    int v=a[h];
    while(true){
        
        while( a[++i]<v);
        
        while(a[--j]>v) if (j==i)  break;
        
        if (i>=j) break;
        
        exch(a,i,j);
        
    }
    
    exch(a,i,h);
    return i;
}

// 17) Write a program to sort numbers using bubble sort?
void bubbleSort(int *array,int length)//Bubble sort function 
{
    int i,j;
    for(i=0;i<10;i++)
    {
        for(j=0;j<i;j++)
        {
            if(array[i]>array[j])
            {
                int temp=array[i]; //swap 
                array[i]=array[j];
                array[j]=temp;
            }
            
        }
        
    }
    
}

void printElements(int *array,int length) //print array elements
{
    int i=0;
    for(i=0;i<10;i++)
        cout<<array[i] << " ";
    cout << endl;
}

int*ReverseArray(int*orig,unsigned short int b)
{
    unsigned short int a=0;
    int swap;
    
    for(a;a<--b;a++) //increment a and decrement b until they meet eachother
    {
        swap=orig[a];       //put what's in a into swap space
        orig[a]=orig[b];    //put what's in b into a
        orig[b]=swap;       //put what's in the swap (a) into b
    }
    
    return orig;    //return the new (reversed) string (a pointer to it)
}


int main(){
    
    // 17) Write a program to sort numbers using quick sort?
    int a[]={12,43,13,5,8,10,11,9,20,17};
    int n=sizeof(a)/sizeof(int);
    quick(a,0,n-1);
    for (int  i=0;i<n;i++){
        cout<<a[i]<<"  ";
    }
    cout << endl;
    
    // 17) Write a program to sort numbers using bubble sort?
    int b[]={9,6,5,23,2,6,2,7,1,8};   // array to sort 
    bubbleSort(b,10);                 //call to bubble sort  
    printElements(b,10);               // print elements
    cout << endl;
    
    // Change order of array
    const unsigned short int SIZE=10;
    int ARRAY[SIZE]={1,2,3,4,5,6,7,8,9,10};
    int*arr=ARRAY;
    
    for(int i=0;i<SIZE;i++)
    {
        cout<<arr[i]<<' ';
    }
    cout<<std::endl;
    arr=ReverseArray(arr,SIZE);
    for(int i=0;i<SIZE;i++)
    {
        cout<<arr[i]<<' ';
    }
    cout<<std::endl;
    cin.get();
    
    return 0;
}