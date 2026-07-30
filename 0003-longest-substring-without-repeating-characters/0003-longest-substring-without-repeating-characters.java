class Solution {
    public int lengthOfLongestSubstring(String s) {
         int left=0,max=0;
        int [] arr=new int[256];
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            left=Math.max(left,arr[ch]);
            max=Math.max(max,right-left+1);
            arr[ch]=right+1;
        }
        return max;
    }
}