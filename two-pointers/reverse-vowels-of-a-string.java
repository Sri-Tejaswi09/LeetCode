import java.util.HashSet;
import java.util.Set;

class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(arr[left])) left++;
            while (left < right && !vowels.contains(arr[right])) right--;
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
}
