class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // no subarray product can be < k if k <= 1

        int count = 0;
        int left = 0;
        long product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }

            // all subarrays ending at right with product < k
            count += (right - left + 1);
        }

        return count;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100)); // Output: 8
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{1,2,3}, 0));     // Output: 0
    }
}
