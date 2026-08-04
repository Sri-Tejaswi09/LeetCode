import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store prefix sum frequencies
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // base case: sum=0 occurs once

        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;

            // Check if (currSum - k) exists
            if (prefixCount.containsKey(currSum - k)) {
                count += prefixCount.get(currSum - k);
            }

            // Update frequency of currSum
            prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 1, 1};
        System.out.println(sol.subarraySum(nums1, 2)); // Output: 2

        int[] nums2 = {1, 2, 3};
        System.out.println(sol.subarraySum(nums2, 3)); // Output: 2
    }
}
