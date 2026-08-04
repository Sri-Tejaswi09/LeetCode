class Solution {
    public int[] plusOne(int[] digits) {
       int n = digits.length;

        // Traverse from the end (least significant digit)
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // No carry needed
                digits[i]++;
                return digits;
            }

            // Set current digit to 0 and continue to handle carry
            digits[i] = 0;
        }

        // If loop completes, it means all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1; // All others are already 0 by default
        return result; 
    }
}