class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        Integer[][] memo = new Integer[n][k + 1];
        return dp(s, 0, k, memo);
    }

    private int dp(String s, int i, int k, Integer[][] memo) {
        if (k < 0) return Integer.MAX_VALUE / 2; // invalid
        if (i >= s.length() || s.length() - i <= k) return 0; // delete all
        if (memo[i][k] != null) return memo[i][k];

        int res = dp(s, i + 1, k - 1, memo); // delete s[i]

        int same = 0, diff = 0;
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i)) {
                same++;
                res = Math.min(res, lengthOfRun(same) + dp(s, j + 1, k - diff, memo));
            } else {
                diff++;
                if (diff > k) break;
            }
        }
        return memo[i][k] = res;
    }

    private int lengthOfRun(int count) {
        if (count == 1) return 1;
        if (count < 10) return 2;
        if (count < 100) return 3;
        return 4;
    }
}
