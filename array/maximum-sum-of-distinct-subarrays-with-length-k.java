import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        long currentSum = 0;
        long maxSum = 0;

        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            currentSum += nums[i];

            if (i >= k) {
                int out = nums[i - k];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0) freq.remove(out);
                currentSum -= out;
            }

            if (i >= k - 1 && freq.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum; // return long
    }
}
