//
//  Missing Numbers.swift
//  Project
//
//  Created by Manuel Escrig on 1/27/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

func missingOneNumber(numbers: [Int]) -> Int {
    var result = 0
    var sum = 0
    for number in numbers {
        sum = sum + number
    }
    var totalSum = 0
    for index in 0...numbers.count {
        totalSum = totalSum + index
    }
    result = totalSum - sum
    print("totalSum \(totalSum) sum \(sum)")
    return result
}

func missingTwoNumbers(numbers: [Int]) -> [Int] {
    var result = [Int]()
    
    let count = numbers.count + 2
    var exist = Array<Bool>(repeating: false, count: count)

    for number in numbers {
        exist[number - 1] = true
    }
    
    for (index, value) in exist.enumerated() {
        if !value {
            result.append(index + 1)
        }
    }
    return result
}
