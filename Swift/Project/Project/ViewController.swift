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

//        let result = migratoryBirds(arr: [1,2,3,4,5,4,3,2,1,3,4])
//        print("migratoryBirds = \(result)")

//        let result = dayOfProgrammer(year: 1800)
//        print("dayOfProgrammer = \(result)")

        let result = pageCount(n: 6, p: 2)
//        let result = pageCount(n: 5, p: 4)
        print("pageCount = \(result)")
    }
}

