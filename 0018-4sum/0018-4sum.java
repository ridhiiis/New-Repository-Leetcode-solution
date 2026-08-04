import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Prune: smallest possible sum from i is already too big
            long minSum1 = (long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if (minSum1 > target) break;

            // Prune: largest possible sum from i is still too small
            long maxSum1 = (long) nums[i] + nums[n-1] + nums[n-2] + nums[n-3];
            if (maxSum1 < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                long minSum2 = (long) nums[i] + nums[j] + nums[j+1] + nums[j+2];
                if (minSum2 > target) break;

                long maxSum2 = (long) nums[i] + nums[j] + nums[n-1] + nums[n-2];
                if (maxSum2 < target) continue;

                int left = j + 1, right = n - 1;
                long remaining = (long) target - nums[i] - nums[j];

                while (left < right) {
                    long currSum = (long) nums[left] + nums[right];

                    if (currSum == remaining) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (currSum < remaining) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}