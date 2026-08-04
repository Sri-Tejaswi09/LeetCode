class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        // Count array for numbers from -50 to 50, index 0 corresponds to -50
        int[] count = new int[101];
        
        // Initialize first window
        for (int i = 0; i < k; i++) {
            count[nums[i] + 50]++;
        }
        
        result[0] = getXthNegative(count, x);
        
        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the outgoing element
            count[nums[i - k] + 50]--;
            // Add the incoming element
            count[nums[i] + 50]++;
            
            result[i - k + 1] = getXthNegative(count, x);
        }
        
        return result;
    }
    
    private int getXthNegative(int[] count, int x) {
        int negCount = 0;
        for (int i = 0; i < 50; i++) { // Only check negative numbers -50 to -1
            negCount += count[i];
            if (negCount >= x) {
                return i - 50; // Convert index back to value
            }
        }
        return 0; // Fewer than x negative numbers
    }
}
