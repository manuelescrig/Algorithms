#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>
#include <string>
using namespace std;


int str2int (const string &str) {
    stringstream ss(str);
    int num;
    if((ss >> num).fail())
    { 
        //ERROR 
    }
    return num;
}


int decimal_repr_zip ( int A,int B ) {
    int result = -1;
    
    if (A < 0 or  B < 0) {
        return -1;
    }
    
    string NumberA;          
    string NumberB;              
    ostringstream convertA;   
    ostringstream convertB;   
    
    convertA << A;      
    NumberA = convertA.str();
    convertB << B;      
    NumberB = convertB.str();    
    
    cout << "String: " << NumberA << endl;
    cout << "String: " << NumberB << endl;
    
    string newNumber;

    
    for (int i=0; i < NumberA.length() or i < NumberB.length() ; i++)
    {
        if (i < NumberA.length()) 
            newNumber.push_back(NumberA[i]);
        if (i < NumberB.length()) 
            newNumber.push_back(NumberB[i]);
    }
    
    
    if (result > 100000000) {
        return -1;
    }
    
    return str2int(newNumber);
}


int main (int argc, const char * argv[])
{
    int A = 123;
    int B = 67890;
    
    int result;
    result = decimal_repr_zip(A, B);
    cout << "Result: " << result << endl;
    
    return 0;
    
}