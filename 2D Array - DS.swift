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
