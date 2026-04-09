class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            Character each = tasks[i];
            if (!frequency.containsKey(each)) {
                frequency.put(each, 1);
            } else {
                frequency.put(each, frequency.get(each) + 1);
            }
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Character each : frequency.keySet()) {
            maxHeap.add(frequency.get(each));
        }
        int total = 0;
        Queue<int[]> coolingRoom = new LinkedList<>();
        while(!maxHeap.isEmpty() || !coolingRoom.isEmpty()) {
            total++;
            if (!maxHeap.isEmpty()) {
                int removed = maxHeap.remove() - 1;
                if (removed > 0) {
                    coolingRoom.add(new int[] {removed, total + n});
                }
            }
            if (!coolingRoom.isEmpty() && coolingRoom.peek()[1] == total) {
                int[] removed = coolingRoom.remove();
                maxHeap.add(removed[0]);
            }
        }
        return total;
    }
}
