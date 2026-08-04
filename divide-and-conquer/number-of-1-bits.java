public class Solution {
    // Function to return the number of set bits in the binary representation of n
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);  // Add the least significant bit
            n >>>= 1;          // Unsigned right shift by 1 bit
        }
        return count;
    }
}
