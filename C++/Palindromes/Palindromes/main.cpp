//
//  main.cpp
//  Palindromes
//
//  Created by Manuel Escrig on 1/12/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

// 4a) Print all palindromes in a string

#include <iostream>
using namespace std;

void printAllPalindromes(char*);
char* subSequence(char*,int,int);


int main() {
    char *s = "abcddcbaABCDEDCBA";
    printAllPalindromes(s);
    return 0;
}


char* subSequence(char* mainSequence, int from, int to) {
    char * tgt = new char[to-from+1];
    for(int i=0;i<(to-from);i++){
        tgt[i] = mainSequence[i+from];
    }
    tgt[to-from] = '\0';
    return tgt;
}

void printAllPalindromes(char* inputText) {
    if(!inputText) {
        printf("Input cannot be null!");
        return;
    }
    
    if(strlen(inputText)<=2) {
        printf("Minimum three characters should be present\n");
    }
    
    //ODD Occuring Palindromes
    int len = strlen(inputText);
    
    for(int i=1;i<len-1;i++) {
        
        for(int j=i-1,k=i+1; j>=0&&k<len; j--,k++) {
            
            if(inputText[j] == inputText[k]) {
                char* subSeq = subSequence(inputText,j,k+1);
                cout<<subSeq<<endl;
                delete subSeq;
            } else {
                break;
            }
        }
    }
    
    //EVEN Occuring Palindromes
    for(int i=1;i<len-1;i++) {
        for(int j=i,k=i+1;j>=0&&k<len;j--,k++) {
            if(inputText[j] == inputText[k]) {
                char* subSeq = subSequence(inputText,j,k+1);
                cout<<subSeq<<endl;
                delete subSeq;
            } else {
                break;
            }
        }
    }
    
}