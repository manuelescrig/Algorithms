#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
using namespace std;

struct Point3D {
    int x;
    int y;
    int z;
};

int central_sphere_coverage_size ( const vector<Point3D> &A ) {
    
    set<int> results;
    set<int>::iterator it;

    int temp=0;
    for(int i=0; i < A.size(); i++) {
        temp = (A[i].x * A[i].x) + (A[i].y * A[i].y) + (A[i].z * A[i].z);
        results.insert(temp);  
    }
    
    return results.size();
}



int main (int argc, const char * argv[])
{
    vector<Point3D> A;
    
    A.push_back(Point3D());
    A[0].x =  0;
    A[0].y =  5; 
    A[0].z =  4;
    A.push_back(Point3D());
    A[1].x =  0; 
    A[1].y =  0; 
    A[1].z = -3;
    A.push_back(Point3D());
    A[2].x = -2; 
    A[2].y =  1; 
    A[2].z = -6;
    A.push_back(Point3D());
    A[3].x =  1; 
    A[3].y = -2; 
    A[3].z =  2;
    A.push_back(Point3D());
    A[4].x =  1; 
    A[4].y =  1; 
    A[4].z =  1;
    A.push_back(Point3D());
    A[5].x =  4; 
    A[5].y = -4; 
    A[5].z =  3;

    int result;
    result = central_sphere_coverage_size(A);
    cout << "Result: " << result << endl;
    
    
    return 0;
    
}