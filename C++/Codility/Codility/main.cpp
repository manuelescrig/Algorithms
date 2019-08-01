//
//  main.cpp
//  Codility
//
//  Created by Manuel Escrig on 1/13/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include <vector>
#include <map>
#include <math.h>

using namespace std;

// 1) reverse the digits of a decimal number
unsigned long ReverseLong(unsigned long u)
{
    long n = 0;
    long r;
    while ( u )
    {
        r = u % 10;
        u /= 10;
        n *= 10;
        n += r;
    }

    return n;
}

long double ReverseNumber(unsigned long i)
{
    
    int div=1, digits=0;
    
    while(i/div){
        digits++; div*=10;
    }
    
    long double result = 0;
    int tmp = digits;
    
    for(int x=1; x<=digits; x++){
        result += (i%10)*pow((long double)10, (int)--tmp);
        i/=10;
    }
    //cout.precision(15);
    //cout << "Pi: " << result << endl;
    return result;
}

// 2) find if a string is an anagram of a palindrome
int isAnagrmaOfPalindrome(char *string){
    unsigned int bitc = 0, i = 0;
    int out = 0;
    
    while(*string){
        i = *(string++) - 'a';
        bitc ^= (1 << i);
    }
    
    out = (int)(bitc & (bitc - 1));
    
    return !out;
}


// 3) Dominator
int getDominator(const vector<int>& A)
{
    if (A.empty()) {
        return -1;
    }
    
    int counter = 1;
    int candidate = A[0];
    for (size_t i = 1; i < A.size(); ++i) {
        if (A[i] == candidate) {
            ++counter;
        }
        else {
            --counter;
            if (0 == counter) {
                candidate = A[i];
                counter = 1;
            }
        }
    }
    
    counter = 0;
    for (size_t i = 0; i < A.size(); ++i) {
        if (A[i] == candidate) {
            ++counter;
        }
    }
    int dominator = -1;
    if (counter > (A.size() / 2)) {
        dominator = candidate;
    }
    
    return dominator;
}

// 4) Number of integer pairs in the vector that, when added, sums up to K
int kComplement(const vector<int>& A, int K)
{
    map<int, unsigned int> elementCounter;
    
    for (unsigned int i = 0; i < A.size(); ++i) {
        elementCounter[A[i]] += 1;
    }
    
    
    unsigned int kComplements = 0;
    for (unsigned int i = 0; i < A.size(); ++i) {
        kComplements += elementCounter[K - A[i]];
    }
    
    
    return kComplements;
}

// 5) K-sparse number
// http://forumserver.twoplustwo.com/191/programming/codility-challenge-1161099/

char*  myitoa(int val, char *buf, int base){
    
    
    int i = 299999;
    int cnt=0;
    
    for(; val && i ; --i, val /= base)  
    {
        buf[i] = "0123456789abcdef"[val % base];
        cnt++;
    }
    buf[i+cnt+1] = '\0';
    return &buf[i+1];
    
}

int sparse_binary_count (const string &S,const string &T,int K) 
{
    char buf[50];
    char *str1,*tptr,*Sstr,*Tstr;
    int i,len1,len2,cnt=0;
    long int num1,num2;
    char *pend,*ch;
    
    Sstr = (char *)S.c_str();
    Tstr = (char *)T.c_str();
    str1 = (char *)malloc(300001);
    tptr = str1;
    
    num1 = strtol(Sstr,&pend,2);
    num2 = strtol(Tstr,&pend,2);
    
    for(i=0;i<K;i++)
    {
        buf[i] = '0';
    }
    buf[i] = '\0';
    
    for(i=num1;i<=num2;i++)
    {
        str1 = tptr;
        
        if( (i & (i-1))==0)
        {
            if(i >= (pow((float)2,(float)K)))
            {
                cnt++;
                continue;
            }
        }
        str1 = myitoa(i,str1,2);
        
        ch = strstr(str1,buf);
        if(ch == NULL)
            continue;
        else
        {
            if((i % 2) != 0)
                cnt++;
        }
        
    }
    return cnt;
}

// 6) Number of elements in an array a which are absolute distinct

int countDistinct (int *nums, int size) {
    int count = 0;
    
    int behind;
    int current;
    
    for (int i = 0; i < size ;i++) {
        if (i==0) { // Just one number
            count++;
        } else {    // More than one number
            
            behind = nums [i-1];
            current = nums[i];
            
            if (behind != current) {
                count++;
            } 
        }
    }
    return count;
}




int main (int argc, const char * argv[])
{
    int intResult = 0;
    
    // 1) reverse the digits of a decimal number
    unsigned long decimalNumber= 223.3456;
    unsigned long floatResult = ReverseNumber(decimalNumber);
    cout << "Result: " << floatResult << endl;

    
    // 2) find if a string is an anagram of a palindrome
    char superman[256] = "racecar";
    intResult = isAnagrmaOfPalindrome(superman);
    cout << "Result: " << intResult << endl;
    
    // 3) Dominator
    vector<int> Array (13,100);
    intResult= getDominator(Array);
    cout << "Result: " << intResult << endl;
    
    // 4) Number of integer pairs in the vector that, when added, sums up to K
    size_t size = 10;
    vector<int> A;
    int K = 17;
             
    for( int i = 0; i < 10; i++ ) {
        A.push_back(i);
        cout << A.at(i) << " ";
    }
    
    intResult =  kComplement(A, K);
    cout << " - Result: " << intResult << endl;

    // 5) K-sparse number
    // http://forumserver.twoplustwo.com/191/programming/codility-challenge-1161099/

    
    // 6) Number of elements in an array a which are absolute distinct
    int array [] = { -5, -4, -1, -1, 0, 1, 2, 2, 2, 3, 4, 5, 5, 5 ,5 ,5};
    int num_elements = sizeof( array ) / sizeof( array[0] );
    cout << "Elements: " << num_elements << endl;
    intResult = countDistinct (array, num_elements);
    cout << "Result: " << intResult << endl;
    
    
    
    return 0;
}

