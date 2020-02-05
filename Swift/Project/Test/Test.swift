//
//  Test.swift
//  Project
//
//  Created by Manuel Escrig on 1/29/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation


func testing() {
//    var s1 = "abc"
//    let result = doThis(&s1)
//    print("result \(result)")
    
//    let str = "aaabbbcccdddeeeee"
//    var set = Set<Character>()
//    var result = ""
//    for char in str {
//        if set.insert(char).inserted {
//            result = result + String(char)
//        }
//    }
//    print(result)   //  "abcde"

    printTest1({ print("Hello") })
    printTest2(print("Hello"))

}

func printTest2(_ result: @autoclosure () -> Void) {
    print("Before")
    result()
    print("After")
}

func printTest1(_ result: () -> Void) {
    print("Before")
    result()
    print("After")
}

func doThis(_ s: inout String) -> String {
    var s1 = s
    s1 = "xyz"
    return s
}
