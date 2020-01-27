//
//  BarrierArray.swift
//  Project
//
//  Created by Manuel Escrig on 1/27/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

class BarrierArray<T> {
    var array = [T]()
    let concurrentQueue = DispatchQueue(label: "com.ventura.queue", attributes: .concurrent)

    var last: T? {
        var result: T?
        self.concurrentQueue.sync {
            result = self.array.last
        }
        return result
    }

    func append(_ newElement: T) {
        self.concurrentQueue.async(flags: .barrier) {
            self.array.append(newElement)
        }
    }
    
    var count: Int {
        var result: Int?
        self.concurrentQueue.sync {
            result = self.array.count
        }
        return result ?? 0
    }
    
}
