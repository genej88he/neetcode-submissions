class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> freq = new TreeMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < hand.length; i++) {
            if (!freq.containsKey(hand[i])) {
                freq.put(hand[i], 1);
            } else {
                freq.put(hand[i], freq.get(hand[i]) + 1);
            }
            if (!minHeap.contains(hand[i])) {
                minHeap.add(hand[i]);
            }
            
        }
        int index = 0;
        while (index < hand.length) {
            int rightNow = minHeap.peek();
            for (int i = 0; i < groupSize; i++) {
                if (freq.containsKey(rightNow)) {
                    if (freq.get(rightNow) <= 0) {
                        return false;
                    } else {
                        freq.put(rightNow, freq.get(rightNow) - 1);
                    }
                    if (freq.get(rightNow) == 0) {
                        minHeap.remove();
                    }
                    rightNow++;
                }
                index++;
            }
        }
        

        for (Integer each : freq.keySet()) {
            System.out.println(freq.get(each));
            if (freq.get(each) != 0) {
                return false;
            }
        }
        return true;


    }
}
