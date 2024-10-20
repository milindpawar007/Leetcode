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
