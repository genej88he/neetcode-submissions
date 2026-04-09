class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) { 
            maxHeap.add(nums[i]);
        }
        int kth = 0;
        for (int i = 0; i < k; i++) {
            kth = maxHeap.remove();
        }
        return kth;
    }
}
