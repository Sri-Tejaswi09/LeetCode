class Solution {
    public int minOperations(int n) {
        int a = n / 2;
        int b = (n + 1) / 2;
        return a * b;
    }
}