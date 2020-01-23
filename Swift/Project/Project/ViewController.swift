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
        
        let array1 = [1, 2]
        let array2 = [3, 4]
        
        let result = findMedianSortedArrays(array1, array2)
        print("findMedianSortedArrays = \(result)")
    }
}

