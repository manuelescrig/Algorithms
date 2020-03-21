
//
//  Merge Two Sorted Linked List.swift
//  Project
//
//  Created by Manuel Escrig on 2/5/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

func print(_ head: ListNode) {
    var current = head
    while current.next != nil {
        print("[\(current.val)]->", terminator:"")
        if let next = current.next {
            current = next
        }
    }
    print("[\(current.val)]")
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


/*

 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.

 Example:
 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 
 R: 1
  
 */
func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    if l1 == nil { return l2 }
    if l2 == nil { return l1 }
    
    var temp: ListNode?
    var r: ListNode?
    var a = l1
    var b = l2
    
    while a != nil || b != nil {
        print("A: \(String(describing: a?.val)) B: \(String(describing: b?.val)) R: \(String(describing: temp?.val))")
        let node: ListNode?
        if let currentA = a, let currentB = b {
            if currentA.val < currentB.val {
                node = ListNode(currentA.val)
                a = currentA.next
            } else {
                node = ListNode(currentB.val)
                b = currentB.next
            }
            if r == nil {
                r = node
                temp = node
            } else {
                temp?.next = node
                temp = temp?.next
            }
        } else if let currentA = a {
            temp?.next = ListNode(currentA.val)
            temp = temp?.next
            a = currentA.next
        } else if let currentB = b {
            temp?.next = ListNode(currentB.val)
            temp = temp?.next
            b = currentB.next
        }
    }
    return r
}

// [1]->[2]->[3]->[4]->[5]->[6]
//                 ^
//                                ^

func middleNode(_ head: ListNode?) -> ListNode? {
    
    var previousA = head
    var currentA = head
    var currentB = head

    while currentB != nil && currentB?.next != nil {
        previousA = currentA
        currentA = currentA?.next
        currentB = currentB?.next?.next
    }
    previousA?.next = nil
    return currentA
}
