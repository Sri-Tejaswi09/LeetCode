class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3]; // for 'a','b','c'
        int left = 0, count = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'a';
            if (freq[idx] == 0) count++;
            freq[idx]++;

            // shrink window when all three chars are present
            while (count == 3) {
                result += (n - right); // all substrings from left to end are valid

                int leftIdx = s.charAt(left) - 'a';
                freq[leftIdx]--;
                if (freq[leftIdx] == 0) count--;
                left++;
            }
        }

        return result;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numberOfSubstrings("abcabc")); // Output: 10
        System.out.println(sol.numberOfSubstrings("aaacb"));  // Output: 3
        System.out.println(sol.numberOfSubstrings("abc"));    // Output: 1
    }
}
