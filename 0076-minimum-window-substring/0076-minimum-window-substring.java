class Solution {

    public String minWindow(String s, String t) {

        // Edge cases
        if (s == null || t == null || s.length() == 0 || t.length() == 0
                || s.length() < t.length()) {
            return "";
        }

        // Frequency map for ASCII characters
        int[] map = new int[128];

        // Total characters still needed
        int count = t.length();

        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {

            /*
             * EXPAND THE WINDOW
             */

            // If this character was still needed,
            // decrease the number of remaining characters.
            if (map[chS[end++]]-- > 0) {
                count--;
            }

            /*
             * SHRINK THE WINDOW
             */

            while (count == 0) {

                // Update the smallest valid window
                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }

                /*
                 * Remove the leftmost character.
                 *
                 * map[x] == 0
                 *   -> This character was exactly satisfied.
                 *      Removing it makes the window invalid,
                 *      so increase count.
                 *
                 * map[x] < 0
                 *   -> We had extra copies.
                 *      Removing one extra copy is fine.
                 */

                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : new String(chS, startIndex, minLen);
    }
}