class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        result[result.length - 1] = 0;
        for (int i = 0; i < cost.length; i++) {
            result[i] = cost[i];
        }
        int right = 0;
        for (int i = result.length - 3; i >= 0; i--) {
            int one = result[i] + result[i + 1];
            int two = result[i] + result[i + 2];
            result[i] = Math.min(one, two);
        }
        return Math.min(result[0], result[1]);
    }
}
