class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return nums[0];
        
        int prev2 = 0;          // dp[i-2]
        int prev1 = 0;          // dp[i-1]
        
        for (int num : nums) {
            int curr = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
