//
//  Grading Students.swift
//  
//

func gradingStudents(grades: [Int]) -> [Int] {
    var results = grades

    for index in 0..<grades.count {
        let currentGrade = grades[index]
        if currentGrade >= 38 {

            let nextMultiple = currentGrade + (5 - currentGrade % 5)
            if nextMultiple - currentGrade < 3 {
                results[index] = nextMultiple
            }
        }
    }

    return results
}

let grates = [73, 67, 38, 33]
// print(gradingStudents(grades: grates))
