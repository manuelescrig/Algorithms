//
//  Max Consecutives Ones.swift
//  Project
//
//  Created by Manuel Escrig on 1/23/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 Given a binary array, find the maximum number of consecutive 1s in this array.
 Input: [1,1,0,1,1,1]
 Output: 3
 */
func findMaxConsecutiveOnes(_ nums: [Int]) -> Int {
    var result = 0
    var currentMax = 0
    for number in nums {
        if number == 1 {
            currentMax += 1
        } else {
            if currentMax > result {
                result = currentMax
            }
            currentMax = 0
        }
    }
    if currentMax > result {
        result = currentMax
    }
    return result
}
