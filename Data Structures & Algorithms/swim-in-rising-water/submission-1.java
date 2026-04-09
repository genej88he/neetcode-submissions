class Solution {
    public int swimInWater(int[][] grid) {
        int size = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{grid[0][0], 0, 0});
        boolean[][] seen = new boolean[size][size];
        seen[0][0] = true;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];
            if (x == size - 1 && y == size - 1) {
                System.out.println(x);
                System.out.println(y);

                return cost;
            }
            for (int[] allDirec : dir) {
                int newX = allDirec[0] + x;
                int newY = allDirec[1] + y;
                if (newX >= 0 && newX < size && newY >= 0 && newY < size && !seen[newX][newY]) {
                    seen[newX][newY] = true;
                    int newCost = Math.max(cost, grid[newX][newY]);
                    minHeap.add(new int[] {newCost, newX, newY});
                }
            }
        }
        return -1;
    }
}
