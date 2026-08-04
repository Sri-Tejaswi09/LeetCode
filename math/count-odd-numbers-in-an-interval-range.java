class Solution {
    public int countOdds(int low, int high) {
        return countOddsUpTo(high) - countOddsUpTo(low - 1);
    }
    private int countOddsUpTo(int x) {
        if (x < 0) return 0;
        return (x + 1) / 2;
    }
}