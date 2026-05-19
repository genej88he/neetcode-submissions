class Solution {
    public boolean canJump(int[] nums) {
        boolean[] result = new boolean[nums.length];
        int length = nums.length - 1;
        if (length <= 0) {
            return true;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= length) {
                length = i;
            }
        }

        if (length == 0) {
            return true;
        } else {
            return false;
        }
        
        
    }
}
