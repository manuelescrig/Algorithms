//
//  Is Palindrome.swift
//  Project
//
//  Created by Manuel Escrig on 2/3/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false
 
 allowedCharacters amanaplanacanalpanama
                             ^
 
 123321 => 6
 12321 => 5
 
 */
func isPalindrome(_ s: String) -> Bool {
    let allowedCharacters = s.components(separatedBy: CharacterSet.alphanumerics.inverted).joined().lowercased()
    let halfway = allowedCharacters.count / 2
    var hasMiddleChar = (allowedCharacters.count % 2) != 0
    var stack = [Character]()
    print("allowedCharacters \(allowedCharacters)")
    
    for (index, value) in allowedCharacters.enumerated() {
        print("index \(index) value \(value)")
        if index < halfway {
            stack.append(value)
        } else if hasMiddleChar {
            hasMiddleChar = false
        } else {
            guard let current = stack.popLast() else {
                return false
            }
            
            if current != value {
                return false
            }
        }
    }
    return true
}

/*
 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 Note:
 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 
 "eedede"
 "abca" => true
 */

func validPalindrome(_ s: String) -> Bool {
    let s = Array(s)[0...]
    return valid(s, false)
}

func valid(_ s: ArraySlice<Character>, _ strict: Bool) -> Bool {
    var i = s.startIndex, j = s.endIndex - 1
    while i < j {
        if s[i] != s[j] {
            if strict {
                return false
            }
            let s1 = s[i+1...j], s2 = s[i...j-1]
            return valid(s1, true) || valid(s2, true)
        }
        i += 1
        j -= 1
    }
    return true
}

/*
 
 */

func isPalindrome(_ x: Int) -> Bool {
    let string = String(x)
    
    let count = (string.count/2) + 1
    for offset in 0..<count {
        let start = string.index(string.startIndex, offsetBy: offset)
        let end = string.index(string.endIndex, offsetBy: -offset - 1)
        if string[start] != string[end] {
            return false
        }
    }
    
    return true
}
