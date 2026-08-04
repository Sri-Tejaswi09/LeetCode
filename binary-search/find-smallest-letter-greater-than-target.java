class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (letters[mid] <= target) {
                left = mid + 1; // need a bigger letter
            } else {
                right = mid - 1; // candidate found, but check left side
            }
        }
        
        // If left is out of bounds, wrap around to first element
        return letters[left % letters.length];
    }
}
