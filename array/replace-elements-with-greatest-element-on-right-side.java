class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxRight = -1;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];   // Store current before overwriting
            arr[i] = maxRight;      // Replace current with max to the right
            maxRight = Math.max(maxRight, current); // Update max
        }

        return arr;
    }
}
