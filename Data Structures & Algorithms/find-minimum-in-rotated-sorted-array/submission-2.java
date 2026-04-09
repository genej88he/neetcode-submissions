class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int low, int high) {
        if (low >= high) {
            return nums[low];
        } else {
            int mid = low + ((high - low) / 2);
            if (nums[mid] > nums[high]) {
                return findMin(nums, mid + 1, high);
            } else {
                return findMin(nums, low, mid);
            }
        }

    }
}
