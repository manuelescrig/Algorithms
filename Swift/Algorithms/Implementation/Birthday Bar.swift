//
//  Birthday Bar.swift

import UIKit

// Complete the birthday function below.
func birthday(s: [Int], d: Int, m: Int) -> Int {
    var result = 0

    for index in 0..<s.count {

        if index + m <= s.count {
            var currentSum = 0
            var currentIndex = 0

            for j in index..<index + m {
                currentSum += s[j]
                currentIndex += 1
            }

            if currentIndex == m && currentSum == d {
                result += 1
            }
        }
    }

    return result
}


let s = [1, 2, 1, 3, 2]
// print(birthday(s: s, d: 3, m: 2))
// Result = 2

//let s = [1, 1, 1, 1, 1, 1]
//print(birthday(s: s, d: 3, m: 2))
// Result = 0

//let s = [4]
//print(birthday(s: s, d: 4, m: 1))
// Result = 1

