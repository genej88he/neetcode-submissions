class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < hand.length; i++) {
            if (!freq.containsKey(hand[i])) {
                freq.put(hand[i], 1);
            } else {
                freq.put(hand[i], freq.get(hand[i]) + 1);
            }  
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.keySet());

        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();

            for (int i = 0; i < groupSize; i++) {
                if (!freq.containsKey(first)) {
                    return false;
                }
                freq.put(first, freq.get(first) - 1);
                if (freq.get(first) == 0 && minHeap.peek() != first) {
                    return false;
                }
                if (freq.get(first) == 0) {
                    minHeap.remove();
                }
                first++;
            }
        }
        return true;
    }
}
