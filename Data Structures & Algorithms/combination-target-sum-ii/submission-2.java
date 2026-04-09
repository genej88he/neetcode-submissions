class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> soFar = new ArrayList<>();
        combinationSum2(candidates, target, soFar, result, 0);
        return result;
    }

    private void combinationSum2(int[] candidates, int target, List<Integer> soFar, List<List<Integer>> result, int start) {
        if (target == 0) {
            if (!result.contains(soFar)) {
                result.add(new ArrayList<>(soFar));
            }   
        }

        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                soFar.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], soFar, result, i + 1);
                soFar.remove(soFar.size() - 1);
            }
        }
    }
}
