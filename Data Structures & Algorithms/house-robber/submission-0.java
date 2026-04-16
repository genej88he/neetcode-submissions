class Solution {
    public int rob(int[] nums) {
        int index = 0;
        int[] memo = new int[nums.length];
        return rob(nums, index, memo);
    }

    private int rob(int[] nums, int index, int[] memo) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        int robCurrent = nums[index] + rob(nums, index + 2, memo);

        int skipCurrent = rob(nums, index + 1, memo);
        
        memo[index] = Math.max(robCurrent, skipCurrent);
        return memo[index];
    }
}
