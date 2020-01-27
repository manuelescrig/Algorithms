//
//  SerialQueueArray.swift
//  Project
//
//  Created by Manuel Escrig on 1/27/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

class SerialQueueArray<T> {
    var array = [T]()
    let serialQueue = DispatchQueue(label: "com.ventura.queue")

    var last: T? {
        var result: T?
        self.serialQueue.sync {
            result = self.array.last
        }
        return result
    }

    func append(_ newElement: T) {
        self.serialQueue.async() {
            self.array.append(newElement)
        }
    }
    
    var count: Int {
        var result: Int?
        self.serialQueue.sync {
            result = self.array.count
        }
        return result ?? 0
    }
}
