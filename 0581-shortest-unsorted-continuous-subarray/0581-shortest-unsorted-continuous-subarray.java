class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i; // this index is out of order relative to something on its left
            } else {
                max = nums[i]; // update running max
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i; // this index is out of order relative to something on its right
            } else {
                min = nums[i]; // update running min
            }
        }

        return right - left + 1;
    }
}