//
//  Is Anagram.swift
//  Project
//
//  Created by Manuel Escrig on 1/24/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

func isAnagram(_ s: String, _ t: String) -> Bool {
    if s.count != t.count { return false }
    let s1 = s.lowercased()
    let s2 = t.lowercased()
    
    var values = [Character: Int]()
    for char in s1 {
        if let count = values[char] {
            values[char] = count + 1
        } else {
            values[char] = 1
        }
    }
    for char in s2 {
        if let count = values[char] {
            values[char] = count - 1
        } else {
            return false
        }
    }
    for (_, value) in values {
        if value != 0 {
            return false
        }
    }
    return true
}

