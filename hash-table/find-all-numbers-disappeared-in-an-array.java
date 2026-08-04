import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Step 1: Mark numbers seen
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            // Only mark if not already marked negative
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Step 2: Find indexes which are still positive
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);  // i + 1 is missing
            }
        }

        return result;
    }
}
