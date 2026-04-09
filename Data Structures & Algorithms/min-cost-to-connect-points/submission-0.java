class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[points.length];
        int edgesUsed = 0;
        int totalCost = 0;
        minHeap.add(new int[]{0, 0});
        while (edgesUsed < points.length && !minHeap.isEmpty()) {
            int[] remove = minHeap.remove();
            int distance = remove[0];
            int index = remove[1];

            if (!visited[index]) {
                visited[index] = true;
                edgesUsed++;
                totalCost += distance;

                for (int i = 0; i < points.length; i++) {
                    if (!visited[i]) {
                        int dist = Math.abs(points[index][0] - points[i][0]) + Math.abs(points[index][1] - points[i][1]);
                        minHeap.add(new int[]{dist, i});
                    }
                }
            }
        }
        return totalCost;
    }
}
