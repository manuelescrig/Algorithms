//
//  ViewController.swift
//  Project
//
//  Created by Manuel Escrig on 28/9/18.
//  Copyright © 2018 Manuel. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

//        let result = birthdayCakeCandles(ar: [3,2,1,3])
//        print("birthdayCakeCandles = \(result)")
//
//        let result = migratoryBirds(arr: [1,2,3,4,5,4,3,2,1,3,4])
//        print("migratoryBirds = \(result)")
//
//        let result = dayOfProgrammer(year: 1800)
//        print("dayOfProgrammer = \(result)")
//
//        let result = pageCount(n: 6, p: 2)
//        let result = pageCount(n: 5, p: 4)
//
//        let array = [4,3,2,7,8,2,3,1]
//        let result = findDuplicates(array)
//
//        let array = [1,1,0,1,1,1]
//        let result = findMaxConsecutiveOnes(array)
//
//        let array = [0,1,0]
//        let result = findMaxLength(array)
//        print("findMaxConsecutiveOnes = \(result)")
//
//        let array = [100, 4, 200, 1, 3, 2]
//        let result = longestConsecutive(array)
        
//        let array1 = [1, 2]
//        let array2 = [3, 4]
//        let result = findMedianSortedArrays(array1, array2)
//        print("findMedianSortedArrays = \(result)")
        
//        let array = [1,1,1,2,2,3]
//        let result = topKFrequent(array, 2)
//        print("topKFrequent = \(result)")

//        let array = ["i", "love", "leetcode", "i", "love", "coding"]
//        let result = topKFrequent(array, 2)
//        print("topKFrequent = \(result)")

//        let paragraph = "Bob. hIt, baLl"
//        let  banned = ["bob", "hit"]
//        let result = mostCommonWord(paragraph, banned)
//        print("mostCommonWord = \(result)")
  
//        let s = "anagram"
//        let t = "nagaram"
//        let result = isAnagram(s, t)
//        print("mostCommonWord = \(result)")
        
//        macICanBuy(budget: 100, closure: { mac in
//            print("I can afford a \(mac)")
//        })
//
//        // Generates 10 threads
//        DispatchQueue.concurrentPerform(iterations: 10) { [weak self] index in
//            self?.array.append(newElement: index)
//            print("self?.array.count \(self?.array.count)")
//        }
        
        let numbers = [2,3,1,6]
        let result = missingTwoNumbers(numbers: numbers)
        print("missingOneNumber = \(result)")
    }
    
    // MARK: - @escaping closures
    
//    func macICanBuy(budget: Int, closure: (String) -> Void) {
//        print("checking budget...")
//
//        closure("Mcdonalds' Big Mac")
//
//        print("macICanBuy finished execution")
//    }
//
//    func macICanBuy(budget: Int, closure: @escaping (String) -> Void) {
//        print("checking budget...")
//
//        // execute the closure 2 seconds after current time
//        DispatchQueue.main.asyncAfter(deadline: .now() + 2, execute: {
//            closure("Mcdonalds' Big Mac")
//        })
//
//        print("macICanBuy finished execution")
//    }
    
    // MARK: - Thread safe
    
//    var array = SerialQueueArray<Int>()
//    var array = BarrierArray<Int>()
//    var array = SynchronizedArray<Int>()

}

