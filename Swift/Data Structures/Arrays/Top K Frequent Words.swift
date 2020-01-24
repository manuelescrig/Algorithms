//
//  Top K Frequent Words.swift
//  Project
//
//  Created by Manuel Escrig on 1/24/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

func topKFrequent(_ words: [String], _ k: Int) -> [String] {
    var result = [String]()
    var candidates = [String:Int]()
    for word in words {
        if let value = candidates[word] {
            candidates[word] = value + 1
        } else {
            candidates[word] = 1
        }
    }
    
    var top = k
    let sortedCandidates = candidates.sorted {  $0.1 > $1.1 }
    sortedCandidates.forEach { key, value in
        if top > 0 {
            result.append(key)
        }
        top = top - 1
    }
    return result
}
