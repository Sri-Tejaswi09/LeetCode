class Solution {
    public boolean checkIfPangram(String sentence) {
        // Boolean array to track presence of each letter
        boolean[] present = new boolean[26];
        
        // Mark letters present in the sentence
        for (char ch : sentence.toCharArray()) {
            present[ch - 'a'] = true;
        }
        for (boolean b : present) {
            if (!b) return false;
        }
        
        return true;
    }
}