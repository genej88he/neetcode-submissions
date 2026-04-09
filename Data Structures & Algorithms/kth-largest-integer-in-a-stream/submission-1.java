class KthLargest {
    private int k;
    private int[] nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }
    
    public int add(int val) {
        int[] newNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        newNums[nums.length] = val;
        nums = newNums;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.remove();
        }
        return maxHeap.remove();
    }
}
