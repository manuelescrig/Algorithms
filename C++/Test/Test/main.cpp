//
//  main.cpp
//  Test
//
//  Created by Manuel Escrig on 1/13/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int falling_disks ( const vector<int> &A,const vector<int> &B ) {
    
    int count = 0;
    int indexA = A.size();
    bool insert = false;
    cout << "IndexA: " << indexA << endl;
    
    for(int i=0; i< B.size(); i++) {
        
        int j=0; 
        while(B[i] <= A[j] and (j < indexA)) {
            cout << "i: " << i << " j: " << j;
            cout << " B[i]: " << B[i] << " A[j]: " << A[j] << endl;
            insert = true;
            j++;
        } 
        if(indexA > 0) {
            j--;
            if (insert== true)
                count++;
            cout << "IndexA: " << indexA << " j:" << j << endl;
            indexA -= (indexA-j) ;
            cout << "IndexA: " << indexA << endl;

        }
        insert= false;
        cout << "Count: " << count;
        cout << " IndexA: " << indexA << endl;

    }
    return count;
}


int main (int argc, const char * argv[])
{
    /*
    vector<int> A;
    A.push_back(5);
    A.push_back(6);
    A.push_back(4);
    A.push_back(3);
    A.push_back(6);
    A.push_back(2);
    A.push_back(3);
    cout << "A: ";  
    for(int i=0; i < A.size(); i++) {
        cout << A[i] << " ";
    }
    cout << endl;
    
    vector<int> B;
    B.push_back(2);
    B.push_back(3);
    B.push_back(5);
    B.push_back(2);
    B.push_back(4);
    cout << "B: ";  
    for(int i=0; i < B.size(); i++) {
        cout << B[i] << " ";
    }
    cout << endl;
     */
    
    
    vector<int> A;
    A.push_back(6);
    A.push_back(15);
    A.push_back(5);
    A.push_back(17);
    A.push_back(20);
    A.push_back(16);
    A.push_back(17);
    A.push_back(10);
    A.push_back(13);
    A.push_back(8);
    A.push_back(10);
    cout << "A: ";  
    for(int i=0; i < A.size(); i++) {
        cout << A[i] << " ";
    }
    cout << endl;
     
    vector<int> B;
    B.push_back(7);
    B.push_back(4);
    B.push_back(4);
    B.push_back(3);
    B.push_back(1);
    cout << "B: ";  
    for(int i=0; i < B.size(); i++) {
        cout << B[i] << " ";
    }
    cout << endl;
    
    
    int result;
    result = falling_disks(A, B);
    cout << "Result: " << result << endl;
    
    return 0;
}

