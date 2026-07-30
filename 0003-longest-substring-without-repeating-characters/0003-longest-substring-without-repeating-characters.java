import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1; // jump left past the duplicate
            }

            lastSeen.put(c, right); // update most recent index of this character
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}