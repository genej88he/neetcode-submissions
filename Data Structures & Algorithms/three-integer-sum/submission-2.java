class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums[0]);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> result2 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                int target = -1 * nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right && right < nums.length) {
                    if (nums[left]+ nums[right] < target) {
                        left++;
                    } else if (nums[left]+ nums[right] > target){
                        right--;
                    } else {
                        List<Integer> need = new ArrayList<>();
                        need.add(nums[i]);
                        need.add(nums[left]);
                        need.add(nums[right]);
                        result2.add(need);
                        left++;
                        right--;
                    }
                }
            }
            
        }
        for (List<Integer> each : result2) {
            result.add(each);
        }
        return result;
    }
}
