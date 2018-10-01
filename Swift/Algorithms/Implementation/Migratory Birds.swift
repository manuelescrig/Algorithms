//
//  Migratory Birds.swift
//  Project
//
//  Created by Manuel Escrig on 28/9/18.
//  Copyright © 2018 Manuel. All rights reserved.
//

import Foundation

// Complete the migratoryBirds function below.
func migratoryBirds(arr: [Int]) -> Int {

    var birds = [Int: Int]()
    for index in 0..<arr.count {
        let value = arr[index]
        if let currentValue = birds[value] {
            birds[value] = currentValue + 1
        } else {
            birds[value] = 1
        }
    }

    var bird = 0
    var frequency = 0
    for (type, number) in birds {
        if number > frequency {
            frequency = number
            bird = type
        } else if number == frequency && type < bird {
            frequency = number
            bird = type
        }
    }

    return bird
}

