class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int left, int right) {
        if (left >= right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        int mid = (left + right) / 2;
        if (nums[left] <= nums[mid]) {  
            if (target > nums[mid] || target < nums[left]) {
                return searchHelper(nums, target, mid + 1, right);
            } else {
                return searchHelper(nums, target, left, mid);
            }
        } else {
            if (target <= nums[mid] || target > nums[right]) {
                return searchHelper(nums, target, left, mid);
            } else {
                return searchHelper(nums, target, mid + 1, right);
            }
        }  
    }
}
