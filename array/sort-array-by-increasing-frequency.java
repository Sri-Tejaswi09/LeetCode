class Solution {
    public int[] frequencySort(int[] nums) {
         HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int fa = freq.get(a);
                int fb = freq.get(b);
                if (fa != fb) {
                    return fa - fb; 
                }
                return b - a; 
            }
        });
        int[] result = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}