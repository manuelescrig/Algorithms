import java.util.*;

/*
Find the median of two sorted arrays.

arr1 = [​1​, ​3​, ​5​]
arr2 = [​2​, ​4​, ​6​] 
median(arr1, arr2) = ​3.5
*/

// A Simple Merge based O(n) solution  
// to find median of two sorted arrays 
  
class MedianOfArrays  { 
    
    // Function to calculate median 
    static int getMedian(int ar1[], int ar2[], int n) {    
        int i = 0;   
        int j = 0;  
        int count; 
        int m1 = -1, m2 = -1; 
       
        /* Since there are 2n elements, median will  
           be average of elements at index n-1 and  
           n in the array obtained after merging ar1  
           and ar2 */
        for (count = 0; count <= n; count++) { 
            /* Below is to handle case where all  
              elements of ar1[] are smaller than  
              smallest(or first) element of ar2[] */
            if (i == n) { 
                m1 = m2; 
                m2 = ar2[0]; 
                break; 
            } else if (j == n) { 
              /* Below is to handle case where all  
               elements of ar2[] are smaller than  
               smallest(or first) element of ar1[] */
                m1 = m2; 
                m2 = ar1[0]; 
                break; 
            } 
       
            if (ar1[i] < ar2[j]) {    
                /* Store the prev median */
                m1 = m2;   
                m2 = ar1[i]; 
                i++; 
            } else { 
                /* Store the prev median */
                m1 = m2;   
                m2 = ar2[j]; 
                j++; 
            } 
        } 
       
        return (m1 + m2)/2; 
    } 
       
    /* Driver program to test above function */
    public static void main (String[] args) { 
        int ar1[] = {1, 12, 15, 26, 38}; 
        int ar2[] = {2, 13, 17, 30, 45}; 
       
        int n1 = ar1.length; 
        int n2 = ar2.length; 
        if (n1 == n2) {
            System.out.println("Median is " + getMedian(ar1, ar2, n1)); 
        } else {
            System.out.println("arrays are of unequal size"); 
        }
    }     
} 