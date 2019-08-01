//
//  main.cpp
//  NewTest
//
//  Created by Manuel Escrig on 1/24/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include <iomanip>
#include <vector>
#include <string>

using namespace std;

class A {
public:
    A() {cout<<"A:A() - ";}
    virtual void Foo() {cout << "A:Foo() - ";}
};

class B: public A{
    public:
    B() { cout << "B:B() - ";}
    virtual void Foo() {cout << "B:Foo() - ";}


};

extern void print(int *ia, int sz);
void print(int *array, int size);

int main (int argc, const char * argv[])
{


    
    return 0;
}

