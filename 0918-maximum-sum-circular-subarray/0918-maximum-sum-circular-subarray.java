class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxKadane = nums[0], currentMax = nums[0];
        int minKadane = nums[0], currentMin = nums[0];

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            if (i == 0) continue; // already initialized above with nums[0]

            // standard Kadane's for maximum subarray
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxKadane = Math.max(maxKadane, currentMax);

            // "flipped" Kadane's for minimum subarray
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minKadane = Math.min(minKadane, currentMin);
        }

        // all numbers negative -> wrap-around case is invalid, use normal Kadane's result
        if (maxKadane < 0) {
            return maxKadane;
        }

        int maxWrap = totalSum - minKadane;
        return Math.max(maxKadane, maxWrap);
    }
}