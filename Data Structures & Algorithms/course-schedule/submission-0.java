class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) graph.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses]; // 0=unvisited, 1=in-progress, 2=done

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, state, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return false; // cycle detected
        if (state[node] == 2) return true;  // already fully explored

        state[node] = 1; // mark in-progress
        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, state, neighbor)) return false;
        }
        state[node] = 2; // mark done
        return true;
    }
}