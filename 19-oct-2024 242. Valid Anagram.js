// Given two strings s and t, return true if t is an anagram  of s, and false otherwise.

// Example 1:

// Input: s = "anagram", t = "nagaram"

// Output: true

// Example 2:

// Input: s = "rat", t = "car"

// Output: false


var isAnagram = function(s, t) {
    //  return s.split("").sort().join("") === t.split("").sort().join("")
    if(s.length !== t.length) return false
    
    const charCount = new Map()

    for(const c of s) {
        if(charCount.has(c)) charCount.set(c, charCount.get(c) +1)
        else charCount.set(c, 1) 
    }

    for(const c of t) {
        if(!charCount.has(c)) return false
        charCount.set(c,charCount.get(c) - 1)
        if(charCount.get(c) === 0) charCount.delete(c)      
    }
    return charCount.size === 0
};
