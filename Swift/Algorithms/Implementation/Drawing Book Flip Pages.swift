//
//  Drawing Book Flip Pages.swift
//  Project
//
//  Created by Manuel Escrig on 1/10/18.
//  Copyright © 2018 Manuel. All rights reserved.
//

import Foundation

/*
 * Complete the pageCount function below.
 */
func pageCount(n: Int, p: Int) -> Int {
    print("n \(n) p \(p)")
    // 0,1 2,3 4,5 6,7 8,9 10,11
    let totalFlips = ceil(Double(n + 1) / 2.0)
    let frontFlips = Double(p) / 2.0
    let backFlips = ceil(Double(p + 1) / 2.0)

    print("totalFlips \(totalFlips) frontFlips \(frontFlips) backFlips \(backFlips)")
    return min(Int(frontFlips), Int(totalFlips - backFlips))
}
