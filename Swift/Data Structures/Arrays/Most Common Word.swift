//
//  Most Common Word.swift
//  Project
//
//  Created by Manuel Escrig on 1/24/20.
//  Copyright © 2020 Manuel. All rights reserved.
//

import Foundation

/*
 Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

  

 Example:

 Input:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 Output: "ball"
 Explanation:
 "hit" occurs 3 times, but it is a banned word.
 "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 Note that words in the paragraph are not case sensitive,
 that punctuation is ignored (even if adjacent to words, such as "ball,"),
 and that "hit" isn't the answer even though it occurs more because it is banned.
 
 */
func mostCommonWord(_ paragraph: String, _ banned: [String]) -> String {
    let words = paragraph.components(separatedBy: CharacterSet.whitespacesAndNewlines.union(CharacterSet.punctuationCharacters))
    var candidateWord = ""
    var candidateCount = 0
    var candidatesWords = [String: Int]()
    var bannedWords = Set<String>()
    for each in banned {
        bannedWords.insert(each.lowercased())
    }
    for each in words {
        let word = each.lowercased()
        if !bannedWords.contains(word) && !word.isEmpty {
            if let value = candidatesWords[word] {
                candidatesWords[word] = value + 1
            } else {
                candidatesWords[word] = 1
            }
            if let count = candidatesWords[word] {
                if count > candidateCount {
                    candidateCount = count
                    candidateWord = word
                }
            }
        }
    }
    return candidateWord
}
