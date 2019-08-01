//
//  main.cpp
//  Test
//
//  Created by Manuel Escrig on 1/8/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//


#include <iostream>
#include <string>
using namespace std; // the namespace for cout<< & such functions

int isPalindrome();

int removeCharacter();

void swap (char *x, char *y);
void permute(char *a, int i, int n);
int printPermutation();
void permuteB(char *a, int i, int n);


int main()
{
    // 1) Write code to check a String is palindrome or not?
    //isPalindrome();
    
    // 2) Write a method which will remove any given character from a String?
    //removeCharacter();
        
    // 3) Print all permutation of String both iterative and Recursive way?
    //printPermutation();
    //char a[] = "ABC";  
    //permuteB(a, 0, 2);
    
    return 0;
}

// 1) Write code to check a String is palindrome or not?
int isPalindrome(){
    
    char strn[80];
    cout<<"Enter the string: ";
    cin.getline(strn,80);
    int len=strlen(strn);
    
    
    bool flag=true; // create a Boolean value, "flag" to be used in our loop
    
    for(int c=0;c!=len/2;c++) // do a loop from 0 to half the length of the string
    {
        if(flag) // if it is a palindrome so far
        {
            if(strn[c]!=strn[len-c-1]) // check the characters match
            {
                flag=false; // if they don't set the indicator to false
            }
            
        }
        else
        {
            break; // if it is not a palindrome, exit the for loop
        }
    }
    
    // if flag is true cout "Palindrome" otherwise output "Not Palindrome"
    
    if(flag)
    {
        cout<<"Palindrome";
    }
    else
    {
        cout<<"Not Palindrome";
    }
    
    cin.get();
    return 0;
}

// 2) Write a method which will remove any given character from a String?
int removeCharacter(){
    
    char strn[80];
    cout<<"Enter the string: ";
    cin.getline(strn,80);
    int len=strlen(strn);
    
    char digit;
    cout<<"Enter the character: ";
    cin.get(digit);
    
    char *temp = new char[strlen(strn)]; 
    int j=0;
    
    for (int i=0; i<len; i++) {
        if(strn[i] != digit)
        {
            temp[j] = strn[i];
            j++;
        }
    } 

    // done
    strcpy(strn, temp);
    delete temp;
           
    cout << "New String: " << temp << endl;
    
    cin.get();
    return 0;
}

// 3) Print all permutation of String both iterative and Recursive way?

/* Function to swap values at two pointers */
void swap (char *x, char *y)
{
    char temp;
    temp = *x;
    *x = *y;
    *y = temp;
}

/* Function to print permutations of string
 This function takes three parameters:
 1. String
 2. Starting index of the string
 3. Ending index of the string. */
void permute(char *a, int i, int n) 
{
    int j; 
    if (i == n)
        printf("%s\n", a);
    else
    {
        for (j = i; j <= n; j++)
        {
            swap((a+i), (a+j));
            permute(a, i+1, n);
            swap((a+i), (a+j)); //backtrack
        }
    }
} 


int printPermutation(){
    /* Driver program to test above functions */
    char a[] = "ABC";  
    permute(a, 0, 2);
    getchar(); 

    return 0;
}

void permuteB(char *a, int i, int n)
{
    int j;
    if (i == n)
        printf("%s\n", a);
    else
    {
        for (j = i; j < n; j++) //check till end of string
        {
            swap((a+i), (a+j));
            permute(a, i+1, n);
            swap((a+i), (a+j)); //backtrack
        }
    }
} 

