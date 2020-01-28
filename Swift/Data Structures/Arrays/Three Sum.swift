//
//  Three Sum.swift
//  Project
//
//  Created by Manuel Escrig on 1/28/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
     var result = [Int]()
     for (start, value) in nums.enumerated() {
         
         var end = start + 1
         while (end <= nums.count-1) {
             if nums[start] + nums[end] == target {
                 result.append(start)
                 result.append(end)
                 return result
             }
             end = end + 1
         }
     }
     return result
}

func threeSum(_ nums: [Int]) -> [[Int]] {
    var result = [[Int]]()
    let n = nums.sorted()
    result.last
    
    for start in 0..<n.count-3 {
        if start == 0 || (start > 0 && n[start] > n[start-1]) {
            var middle = start + 1
            var end = n.count - 1
            print("start \(start) middle \(middle) end \(end)")
            while (middle < end) {
                print("start \(start) middle \(middle) end \(end)")
                if n[start] + n[middle] + n[end] == 0 {
                    let success = [n[start], n[middle], n[end]]
                    result.append(success)
                }
                if n[start] + n[middle] + n[end] < 0 {
                    middle = middle + 1
                } else {
                    end = end - 1
                }
            }
        }
    }
    
    return result
}
