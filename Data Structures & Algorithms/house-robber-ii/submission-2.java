class Solution {
    public int rob(int[] nums) {
        int[] excludeLast = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            excludeLast[i] = nums[i];
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int skipFirst = rob1(nums, 1, new int[nums.length]);
        int skipLast = rob1(excludeLast, 0, new int[nums.length]);
        return Math.max(skipFirst, skipLast);
    }

    private int rob1(int[] nums, int index, int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Integer.MIN_VALUE;
        }
        return rob(nums, index, memo);
    }

    private int rob(int[] nums, int index, int[] memo) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != Integer.MIN_VALUE) {
            return memo[index];
        }
        int robThis = nums[index] + rob(nums, index + 2, memo);
        int skip = rob(nums, index + 1, memo);
        memo[index] = Math.max(robThis, skip);
        return memo[index];

    }
}
