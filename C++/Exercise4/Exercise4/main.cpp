#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int min_dist (vector<int> &A ) {
        
    sort( A.begin(), A.end() );
    int min= A[0]-A[0+1];
    
    for(int i=0; i < A.size(); i++) {
        if (i!=0) {
            if (A[i] - A[i-1] < min) {
                min = A[i] - A[i-1];
            }
        }
      
    }

    return abs(min);
}


int main (int argc, const char * argv[])
{
    vector<int> A;
    A.push_back(8);
    A.push_back(24);
    A.push_back(3);
    A.push_back(20);
    A.push_back(1);
    A.push_back(17);
     
    
    int result;
    result = min_dist(A);
    cout << "Result: " << result << endl;
    
    
    return 0;
}