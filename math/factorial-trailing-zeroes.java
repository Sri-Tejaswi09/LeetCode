
public class Solution {
    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 5;
        int n3 = 0;
        System.out.println("Input: " + n1 + " => Output: " + trailingZeroes(n1)); // 0
        System.out.println("Input: " + n2 + " => Output: " + trailingZeroes(n2)); // 1
        System.out.println("Input: " + n3 + " => Output: " + trailingZeroes(n3)); // 0
    }
}
