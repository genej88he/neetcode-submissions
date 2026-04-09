class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        if (target < nums[mid]) {
            return search(nums, low, mid - 1, target);
        } else {
            return search(nums, mid + 1, high, target);
        }
    }
}
