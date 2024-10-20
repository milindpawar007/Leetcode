// 1. Two Sum 
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

var twoSum = function (nums, target) {

    let map = new Map();  // Create a hashmap to store the indices of elements

    for (let i = 0; i < nums.length; i++) 
    {
        let complement = target - nums[i];  // Calculate the number needed to reach the target

        // Check if the complement is already in the map
        if (map.has(complement)) 
        {
            return [map.get(complement), i];  // Return the indices
        }

        // Store the current element's index in the map
        map.set(nums[i], i);
    }
}
