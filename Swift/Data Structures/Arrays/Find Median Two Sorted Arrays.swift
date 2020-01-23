//
//  Find Median Two Sorted Arrays.swift
//  Project
//
//  Created by Manuel Escrig on 1/23/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation
/*
 There are two sorted arrays nums1 and nums2 of size m and n respectively.
 
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 
 You may assume nums1 and nums2 cannot be both empty.
 
 Example 1:
 
 nums1 = [1, 3]
 nums2 = [2]
 
 The median is 2.0
 Example 2:
 
 nums1 = [1, 2]
 nums2 = [3, 4]
 
 The median is (2 + 3)/2 = 2.5
 */
func findMedianSortedArrays(_ nums1: [Int], _ nums2: [Int]) -> Double {
    var A = nums1
    var B = nums2
    var m = nums1.count
    var n = nums2.count
    if m > n {
        let temp = A
        A = B
        B = temp
        let temp2 = m
        m = n
        n = temp2
    }
    var iMin = 0
    var iMax = m
    let halfLen = (m + n + 1) / 2
    while (iMin <= iMax) {
        let i = (iMin + iMax) / 2
        let j = halfLen - i
        if i < iMax && B[j-1] > A[i] {
            iMin = i + 1 // i is too small
        } else if (i > iMin && A[i-1] > B[j]) {
            iMax = i - 1 // i is too big
        } else { // i is too small
            var maxLeft = 0.0
            if i == 0 {
                maxLeft = Double(B[j-1])
            } else if j == 0 {
                maxLeft = Double(A[i-1])
            } else {
                maxLeft = Double(max(A[i-1], B[j-1]))
            }
            if (m + n) % 2 == 1 {
                return maxLeft
            }
            
            var minRight = 0.0
            if i == m {
                minRight = Double(B[j])
            } else if j == n {
                minRight = Double(A[i])
            } else {
                minRight = Double(min(A[i], B[j]))
            }
            
            return (maxLeft + minRight) / 2.0
        }
    }
    return 0.0
}

/*

 class Solution {
     public double findMedianSortedArrays(int[] A, int[] B) {
         int m = A.length;
         int n = B.length;
         if (m > n) { // to ensure m<=n
             int[] temp = A; A = B; B = temp;
             int tmp = m; m = n; n = tmp;
         }
         int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
         while (iMin <= iMax) {
             int i = (iMin + iMax) / 2;
             int j = halfLen - i;
             if (i < iMax && B[j-1] > A[i]){
                 iMin = i + 1; // i is too small
             }
             else if (i > iMin && A[i-1] > B[j]) {
                 iMax = i - 1; // i is too big
             }
             else { // i is perfect
                 int maxLeft = 0;
                 if (i == 0) { maxLeft = B[j-1]; }
                 else if (j == 0) { maxLeft = A[i-1]; }
                 else { maxLeft = Math.max(A[i-1], B[j-1]); }
                 if ( (m + n) % 2 == 1 ) { return maxLeft; }

                 int minRight = 0;
                 if (i == m) { minRight = B[j]; }
                 else if (j == n) { minRight = A[i]; }
                 else { minRight = Math.min(B[j], A[i]); }

                 return (maxLeft + minRight) / 2.0;
             }
         }
         return 0.0;
     }
 }


 */
