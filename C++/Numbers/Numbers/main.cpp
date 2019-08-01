//
//  main.cpp
//  Numbers
//
//  Created by Manuel Escrig on 1/12/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>

using namespace std;

// 19) Write code to check whether a no is power of two or not?
bool power_of_2(int number) {
    if (number == 1)
        return true;
    if (number == 0 || number % 2 != 0)
        return false;
    
    power_of_2(number / 2);
    return true;
}



// 20) Write a program to check whether a no is palindrome or not?
// check out this post which shows how to reverse number in Java and can be used to find if its palindrome or not.

int isPalindrome(){
    
    int len = 6;
    int strn[6] = {1,2,3,5,2,1};
    
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
    cout << endl;
    
    return 0;
}
    
// 21) Write code to check whether a no is Armstrong no or not 

void isArmstrong () { 
    
    int number, sum = 0, temp, remainder;
    
    printf("Enter a number\n");      
    scanf("%d",&number);
    
    temp = number;
    
    while( temp != 0 )
    {
        remainder = temp%10;
        sum = sum + remainder*remainder*remainder;
        temp = temp/10; 
    }
    
    if ( number == sum )
        printf("Entered number is an armstrong number.");
    else
        printf("Entered number is not an armstrong number."); 
    
    cout << endl;
}


// 22) Write a program to find all prime number up to a given numbers?
// Here is another Java program to find prime numbers and print them. By using logic demonstrated in this program; you can write similar program in C and C++.

bool isPrime(int number){
    for(int i=2; i<number; i++){
        if(number%i == 0){
            return false; //number is divisible so its not prime
        }
    }
    return true; //number is prime now
}

void printingPrimeNumbers(int limit) {
    cout << "Printing prime number from 1 to " << limit << endl;
    for(int number = 2; number<=limit; number++){
        //print prime numbers only
        if(isPrime(number)){
            cout << number << " ";
        }
    }
    cout << endl;
    
}

// 23) Write function to compute Nth Fibonacci number? Both iterative and recursive?
// Check this Java program to print Fibonacci Series using recursion and iteration.

int fibonacci1(int number){
    if(number == 1 || number == 2){
        return 1;
    }
    
    return fibonacci1(number-1) + fibonacci1(number -2); //tail recursion
}

int fibonacci2(int number){
    if(number == 1 || number == 2){
        return 1;
    }
    
    int fibo1=1, fibo2=1, fibonacci=1;
    for(int i= 3; i<= number; i++){
        fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
        fibo1 = fibo2;
        fibo2 = fibonacci;
        
    }
    return fibonacci; //Fibonacci number
    
} 

void printingFibonnaciNumbers(int limit) {
    cout << "Fibonacci series up to " << limit << " numbers " << endl;
    //printing Fibonacci series upto number
    for(int i=1; i<=50; i++){
        cout << fibonacci2(i) << " ";
    }
}


int main (int argc, const char * argv[])
{
    // 19) Write code to check whether a no is power of two or not?
    if (power_of_2(633)) {
        cout << "Power of Two? True" << endl;
    }
    else {
        cout << "Power of Two? False" << endl;
    }
    
    // 20) Write a program to check whether a no is palindrome or not?
    // check out this post which shows how to reverse number in Java and can be used to find if its palindrome or not.
    isPalindrome();
    
    
    // 21) Write code to check whether a no is Armstrong no or not 
    //isArmstrong();
    
    // 22) Write a program to find all prime number up to a given numbers?
    printingPrimeNumbers(50);
    
    // 23) Write function to compute Nth Fibonacci number? Both iterative and recursive?
    printingFibonnaciNumbers(50);
    
    return 0;
}

