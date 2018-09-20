 /**
 You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 */
 
 
 func minimumSwaps(arr: [Int]) -> Int {
    
        struct Pair {
            let index: Int
            let value: Int
        }
        
        var positions = arr.enumerated().map { Pair(index: $0, value: $1) }
        positions.sort { $0.value < $1.value }
        var indexes = positions.map { $0.index }
        
        var swaps = 0
        for i in 0 ..< indexes.count {
            var val = indexes[i]
            if val < 0 {
                continue // Already visited.
            }
            while val != i {
                let new_val = indexes[val]
                indexes[val] = -1
                val = new_val
                swaps += 1
            }
            indexes[i] = -1
        }
        return swaps
    }
