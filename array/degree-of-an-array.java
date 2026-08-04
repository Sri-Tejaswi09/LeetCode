import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (!first.containsKey(x)) {
                first.put(x, i);
            }
            last.put(x, i);
        }
        
        int degree = Collections.max(count.values());
        int minLen = nums.length;
        
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                int len = last.get(x) - first.get(x) + 1;
                minLen = Math.min(minLen, len);
            }
        }
        
        return minLen;
    }
}
