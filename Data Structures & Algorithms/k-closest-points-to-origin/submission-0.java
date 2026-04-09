class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] each = points[i];
            int x = each[0];
            int y = each[1];
            int sum = x * x + y * y;
            maxHeap.add(new int[]{sum, x, y});
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        int[][] returned = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] eachEntry = maxHeap.remove();
            returned[i][0] = eachEntry[1];
            returned[i][1] = eachEntry[2];
            i++;
        }
        return returned;
    }
}
