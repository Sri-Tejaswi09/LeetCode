class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            // Move left forward if current is even
            if (nums[left] % 2 == 0) {
                left++;
            } 
            // Move right backward if current is odd
            else if (nums[right] % 2 != 0) {
                right--;
            } 
            // nums[left] is odd and nums[right] is even → swap
            else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        
        return nums;
    }
}
