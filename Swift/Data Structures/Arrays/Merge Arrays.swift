//
//  Merge Arrays.swift
//  Project
//
//  Created by Manuel Escrig on 2/3/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 nums1 = [1,2,3,0,0,0], m = 3
          0 1 2 3 4 5
   
 
 nums2 = [2,5,6],       n = 3
 
 [1] 1
 [] 0
 
 [0] 0
 [1] 1
 
 [2,0] 1
 [1] 1
 
 */
func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
    if m == 0 {
        nums1 = nums2
    }
    if n == 0 {
        return
    }
    
    var i = m - 1
    var j = n - 1
    var k = m + n - 1
    
    while i >= 0 && j >= 0 {
        if nums1[i] >= nums2[j] {
            nums1[k] = nums1[i]
            k -= 1
            i -= 1
        } else {
            nums1[k] = nums2[j]
            k -= 1
            j -= 1
        }
    }
    
    while j >= 0 {
        nums1[k] = nums2[j]
        k -= 1
        j -= 1
    }
}
