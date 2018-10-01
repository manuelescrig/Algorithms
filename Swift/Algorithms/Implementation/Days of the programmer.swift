//
//  Days of the programmer.swift
//  Project
//
//  Created by Manuel Escrig on 1/10/18.
//  Copyright © 2018 Manuel. All rights reserved.
//

import Foundation

// Complete the migratoryBirds function below.
func dayOfProgrammer(year: Int) -> String {
    if year == 1800 {
        return "12.09.\(year)"
    }
    if year == 1918 {
        return "26.09.1918"
    }
    let isLeapYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)

    if isLeapYear {
        return "12.09.\(year)"
    } else {
        return "13.09.\(year)"
    }
}
