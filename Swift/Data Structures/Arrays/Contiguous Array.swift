//
//  Contiguous Array.swift
//  Project
//
//  Created by Manuel Escrig on 1/23/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation
/*
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 Note: The length of the given binary array will not exceed 50,000.
 
 
 [0,0,0,1,1,1,0,1,1,0,0]
                ^
 */
func findMaxLength(_ nums: [Int]) -> Int {
    if nums.count < 1 { return 0 }
    var result = 0
    
    var numberOf0 = 0
    var numberOf1 = 0
    
    var previousNumber = -1
    for (index, number) in nums.enumerated() {
        if index == 0 {
            if number == 0 {
                numberOf0 += 1
            } else {
                numberOf1 += 1
            }
        } else {
            if number == 0 {
                numberOf0 += 1
            } else {
                numberOf1 += 1
            }
            if number != previousNumber {
                if numberOf0 == numberOf1 {
                    let currentTotal = numberOf0 + numberOf1
                    if currentTotal > result {
                        result = currentTotal
                    }
                    numberOf0 = 0
                    numberOf1 = 0
                    if number == 0 {
                        numberOf0 += 1
                    } else {
                        numberOf1 += 1
                    }
                }
            }
        }
        previousNumber = number
    }
    return result
}
