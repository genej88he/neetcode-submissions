class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, heights[i].length - 1, atlantic, heights[i][heights[i].length - 1]);
        }

        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, 0, i, pacific, heights[0][i]);
            dfs(heights, heights.length - 1, i, atlantic, heights[heights.length - 1][i]);
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> ind = new ArrayList<>();
                    ind.add(i);
                    ind.add(j);
                    result.add(ind);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int column, boolean[][] ocean, int spot) {
        if (row >= 0 && row < heights.length && column >= 0 && column < heights[row].length
            && spot <= heights[row][column] && !ocean[row][column]) {
            
            ocean[row][column] = true;
            dfs(heights, row - 1, column, ocean, heights[row][column]);
            dfs(heights, row + 1, column, ocean, heights[row][column]);
            dfs(heights, row, column - 1, ocean, heights[row][column]);
            dfs(heights, row, column + 1, ocean, heights[row][column]);

        }
    }
}
