//
//  Consecutive Array.swift
//  Project
//
//  Created by Manuel Escrig on 1/23/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Your algorithm should run in O(n) complexity.

 Example:

 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
func longestConsecutive(_ nums: [Int]) -> Int {
    var result = 0
    
    var values = Set<Int>()
    for number in nums {
        values.insert(number)
    }
    
    for number in nums {
        var currentMax = 1
        var currentNumber = number + 1
        while values.contains(currentNumber) {
            currentMax += 1
            currentNumber += 1
        }
        
        if currentMax > result {
            result = currentMax
        }
        currentMax = 0
        currentNumber = 0
    }
    
    return result
}
