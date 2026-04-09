class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        while (maxHeap.size() > 1) {
            int biggest = maxHeap.remove();
            int secondBiggest = maxHeap.remove();
            int difference = biggest - secondBiggest;
            maxHeap.add(difference);
        }
        return maxHeap.remove();
    }
}
