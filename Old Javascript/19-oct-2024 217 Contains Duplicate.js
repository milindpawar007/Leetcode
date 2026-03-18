// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Example 1:

// Input: nums = [1,2,3,1]

// Output: true

// Explanation:

// The element 1 occurs at the indices 0 and 3.

// Example 2:

// Input: nums = [1,2,3,4]

// Output: false

var containsDuplicate = function(nums) {
     if(nums.length===1){return false}
     let charCount = new Map();
     for(const c of nums) {
        if(charCount.has(c)) return true
        else charCount.set(c, 0) 
    }
      
   return false
   
};
var containsDuplicate = function(nums) {
        //  return false
    const numsSet = new Set(nums)
        
    return !(numsSet.size === nums.length)
};
