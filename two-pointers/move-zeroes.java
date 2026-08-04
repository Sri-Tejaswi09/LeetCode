class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // position to place the next non-zero
        
        // Step 1: Move all non-zeros forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Step 2: Fill remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
