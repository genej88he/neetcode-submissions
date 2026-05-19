class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= length) {
                length = i;
            }
        }

        return length == 0 ? true : false;
        
        
    }
}
