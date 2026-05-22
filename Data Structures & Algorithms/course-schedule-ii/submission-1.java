class Solution {
    public int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        } 
        for (int[] each : prerequisites) {
            list.get(each[0]).add(each[1]);
        }
        int[] result = new int[numCourses];
        boolean[] done = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, done, visited, list, result)) {
                return new int[0];
            }
        }
        return result;
    }

    private boolean dfs(int startingNum, boolean[] done, boolean[] visited, List<List<Integer>> list, int[] result) {
        if (visited[startingNum]) {
            return false;
        } else if (done[startingNum]) {
            return true;
        } else {
            visited[startingNum] = true;
            List<Integer> thisTime = list.get(startingNum);
            for (int i = 0; i < thisTime.size(); i++) {
                if (!dfs(thisTime.get(i), done, visited, list, result)) {
                    return false;
                }
            }
            visited[startingNum] = false;
            done[startingNum] = true;
            result[index++] = startingNum;
            return true;
        }
    }
}
