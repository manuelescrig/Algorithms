//
//  Top K Frequent Integers.swift
//  Project
//
//  Created by Manuel Escrig on 1/24/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 Given a non-empty array of integers, return the k most frequent elements.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]
 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
func topKFrequent(_ nums: [Int], _ k: Int) -> [Int] {
    var result = [Int]()
    var dictionary = [Int: Int]()
    for number in nums {
        if let value = dictionary[number] {
            dictionary[number] = value + 1
        } else {
            dictionary[number] = 1
        }
    }
    var elements = k
    let sortedByValueDictionary = dictionary.sorted { $0.1 > $1.1 }
    sortedByValueDictionary.forEach { key, value in
        if elements > 0 {
            result.append(key)
        }
        elements = elements - 1
    }
    return result
}
