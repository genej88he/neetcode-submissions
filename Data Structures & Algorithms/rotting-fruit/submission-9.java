class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int totalFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }

                if (grid[i][j] == 1) {
                    totalFresh++;
                }
                
            }
        }
        if (q.isEmpty() && totalFresh != 0) {
            return -1;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int times = 0;
        while (!q.isEmpty() && totalFresh > 0) {
            int totalPopNeeded = q.size();
            for (int i = 0; i < totalPopNeeded; i++) {
                int[] coords = q.remove();
                for (int[] dir : directions) {
                    int x = dir[0];
                    int y = dir[1];
                    int newX = x + coords[0];
                    int newY = y + coords[1];
                    if (newX < grid[0].length && newX >= 0 && newY < grid.length && newY >= 0) {
                        if (grid[newY][newX] == 1) {
                            grid[newY][newX] = 2;
                            totalFresh--;
                            q.add(new int[] {newY, newX});  
                            
                        }
                    }
                }
            }
            times++;
            if (q.isEmpty() && totalFresh != 0) {
                return -1;
            }
            
        } 
        return times;  
    }
}
