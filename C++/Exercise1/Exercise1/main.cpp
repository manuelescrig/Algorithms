#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
using namespace std;

int absDistinctB(vector<int> &A) {
    
    int len = A.size();
    if (len <= 0)
        return 0;
    
    
    vector<int> B = vector<int>(A);
    for (int i = 0; i < len; i++) {
        if (B[i] < 0) 
            B[i] = -B[i];
    }
    
    // and sort so we have a simple absolute count
    sort(B.begin(), B.end());
    
    int result = 1; //count first number always
    for (int j = 1; j < len; j++) {
        if (B[j] != B[j-1])
            result++;
    }
    return result;
    
}


int main (int argc, const char * argv[])
{
    vector<int> A;
    A.push_back(-6);
    A.push_back(-3);
    A.push_back(-1);
    A.push_back(0);
    A.push_back(0);
    A.push_back(0);
    A.push_back(3);
    A.push_back(6);
    A.push_back(7);
    cout << "A: ";  
    for(int i=0; i < A.size(); i++) {
        cout << A[i] << " ";
    }
    cout << endl;
    
    
    int result;
    result = absDistinct(A);
    cout << "Result: " << result << endl;
    
    
    return 0;
    
}

