import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // remainder 0 occurs once initially

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;

            // normalize remainder to be non-negative
            if (remainder < 0) {
                remainder += k;
            }

            // if this remainder was seen before, add its frequency to count
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            // update frequency of this remainder
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5)); // Output: 7
        System.out.println(sol.subarraysDivByK(new int[]{5}, 9));             // Output: 0
    }
}
