class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n-1;
        int writeIndex = n-1; // we fill result backward starting from the last (largest) slot
        while (left <= right) {
            int leftS = nums[left] * nums[left];
            int rightS = nums[right] * nums[right];

            if(leftS > rightS){
                result[writeIndex] = leftS;
                left++;
            } else{
                result[writeIndex] = rightS;
                right--;
            }
            writeIndex--;
        }
        return result; 
    }
}