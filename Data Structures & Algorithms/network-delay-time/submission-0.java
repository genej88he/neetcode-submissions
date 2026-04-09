class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] each = times[i];
            if (!adj.containsKey(each[0])) {
                adj.put(each[0], new ArrayList<>());
            }
            adj.get(each[0]).add(new int[]{each[1], each[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, k});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] seen = new boolean[n + 1];
        int nodesReached = 0;
        int maxTime = 0;
        while (!minHeap.isEmpty()) {
            int[] extract = minHeap.remove();
            int time = extract[0];
            int node = extract[1];
            if (!seen[node]) {
                seen[node] = true;
                nodesReached++;
                maxTime = time;
                if (adj.containsKey(node)) {
                    for (int[] neighbors : adj.get(node)) {
                        int newNode = neighbors[0];
                        int weight = neighbors[1];
                        if (!seen[newNode] && time + weight < dist[newNode]) {
                            dist[newNode] = time + weight;
                            minHeap.add(new int[]{dist[newNode], newNode});
                        }
                    }
                }
            }
        }

        if (nodesReached == n) {
            return maxTime;
        } else {
            return -1;
        }
    }
}

// Distance to start = 0
// Add the start node to PQ with priority 0
// Mark start as “seen”
// While the PQ is not empty:
//  curr = PQ.extract();
//  mark curr as “done”
//  for each neighbor v of curr:
//  d = distance to curr + weight of (curr,v)
//  if v is not “seen”:
//  mark v as “seen”
//  distance to v = d
//  PQ.add(v, d);
//  if v is not “done” && d < distance to v:
//  distance to v = d
//  PQ.decreaseKey(v, d)