class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        // Since nums[i] <= 100, we can use a frequency array for optimization
        int[] freq = new int[101]; 
        
        for (int num : nums) {
            // Count pairs where current number and previous numbers differ by k
            if (num - k >= 1) {
                count += freq[num - k];
            }
            if (num + k <= 100) {
                count += freq[num + k];
            }
            freq[num]++;
        }
        
        // Each pair is counted twice because both (i,j) and (j,i) count, 
        // but problem says i < j, so we counted pairs twice. Let's fix it:
        // Actually, in this approach, we count each pair exactly once because 
        // we only add freq[num - k] and freq[num + k] for previous numbers.
        // So no need to divide by 2.
        
        return count;
    }
}
