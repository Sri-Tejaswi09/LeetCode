class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            // Found valid combination
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0) return; // Exceeded target, stop

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            // Not i+1 because we can reuse the same element
            backtrack(candidates, target - candidates[i], i, tempList, result);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}