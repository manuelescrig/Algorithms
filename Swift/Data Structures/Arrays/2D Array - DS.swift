/**
Given a  2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:
a b c
  d
e f g

There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.
For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0

We calculate the following  hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18

Our highest hourglass value is 28 from the hourglass:
0 4 3
  1
8 6 6

*/

import Foundation

// Complete the hourglassSum function below.
func hourglassSum(arr: [[Int]]) -> Int {
        var max = Int.min
        
        for i in 1..<arr.count-1 {
            for j in 1..<arr[i].count-1{
                var sum = arr[i][j]
                sum += arr[i-1][j-1]
                sum += arr[i-1][j]
                sum += arr[i-1][j+1]
                sum += arr[i+1][j-1]
                sum += arr[i+1][j]
                sum += arr[i+1][j+1]
                if sum >= max {
                    max = sum
                }
            }
        }
        
        return max

}

let stdout = ProcessInfo.processInfo.environment["OUTPUT_PATH"]!
FileManager.default.createFile(atPath: stdout, contents: nil, attributes: nil)
let fileHandle = FileHandle(forWritingAtPath: stdout)!

let arr: [[Int]] = AnyIterator{ readLine() }.prefix(6).map {
    let arrRow: [Int] = $0.split(separator: " ").map {
        if let arrItem = Int($0.trimmingCharacters(in: .whitespacesAndNewlines)) {
            return arrItem
        } else { fatalError("Bad input") }
    }

    guard arrRow.count == 6 else { fatalError("Bad input") }

    return arrRow
}

guard arr.count == 6 else { fatalError("Bad input") }

let result = hourglassSum(arr: arr)

fileHandle.write(String(result).data(using: .utf8)!)
fileHandle.write("\n".data(using: .utf8)!)
