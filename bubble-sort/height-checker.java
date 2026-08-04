import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // Step 1: Copy and sort the original array
        int[] expected = heights.clone();
        Arrays.sort(expected);

        // Step 2: Count mismatched positions
        int mismatchCount = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatchCount++;
            }
        }

        return mismatchCount;
    }
}
