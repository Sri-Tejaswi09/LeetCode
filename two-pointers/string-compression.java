class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;  // position to write compressed chars
        int read = 0;   // position to read original chars

        while (read < n) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive occurrences
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if > 1
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}
