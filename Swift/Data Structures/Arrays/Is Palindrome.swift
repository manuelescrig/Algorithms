//
//  Is Palindrome.swift
//  Project
//
//  Created by Manuel Escrig on 2/3/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

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


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */

public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

func isPalindrome(_ head: ListNode?) -> Bool {
    var curr = head
    var runner = head
    var values = [Int]()
    
    while runner != nil && runner?.next != nil {
        if let current = curr?.val {
            values.append(current)
        }
        curr = curr?.next
        runner = runner?.next?.next
    }
    
    if (runner != nil) {
        curr = curr?.next
    }
    
    while curr != nil {
        let popValue = values.popLast()
        if let current = curr?.val {
            if current != popValue {
                return false
            }
        }
        curr = curr?.next
    }
    
    return true
}
