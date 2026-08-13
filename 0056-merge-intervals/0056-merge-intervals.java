import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMerged = result.get(result.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= lastMerged[1]) {
                // overlapping -> merge by extending the end if needed
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // no overlap -> add as a new interval
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}