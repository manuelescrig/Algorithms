//
//  Birthday Cake Candles.swift
//  Project
//
//  Created by Manuel Escrig on 28/9/18.
//  Copyright © 2018 Manuel. All rights reserved.
//

import Foundation

func birthdayCakeCandles(ar: [Int]) -> Int {
    var result = 0
    var highestCandle = 0

    for index in 0..<ar.count {
        let value = ar[index]
        if value > highestCandle {
            highestCandle = value
            result = 1
        } else if value == highestCandle {
            result += 1
        }
    }

    return result
}
