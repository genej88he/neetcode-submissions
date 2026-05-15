class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        // List<Integer> runningList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            System.out.println(curr);
            System.out.println("----");
            if (curr > 0) {
                max = Math.max(curr, max);
            } else {
                max = Math.max(curr, max);
                curr = 0;
            }
        }
        return max;
    }
}
