//
//  Find All Duplicates.swift
//  Project
//
//  Created by Manuel Escrig on 1/23/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 Question:​ Given an array of integers where each value 1 <= x <= len(array), write a function that finds all the duplicates in the array.
 */
func findDuplicates(_ nums: [Int]) -> [Int] {
    var set = Set<Int>()
    var result = [Int]()
    for number in nums {
        let inserted = set.insert(number)
        if !inserted.inserted {
            result.append(number)
        }
    }
    return result
}
