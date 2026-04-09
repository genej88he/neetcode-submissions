class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> topK = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int eachNum = nums[i];
            if (!map.containsKey(eachNum)) {
                map.put(eachNum, 0);
            }
            int oldValue = map.get(eachNum);
            map.put(eachNum, oldValue + 1);
        }
        for (Integer num : map.keySet()) {
            topK.add(new int[]{num, map.get(num)});
        }
        for (int i = 0; i < k; i++) {
            result[i] = topK.remove()[0];
        }
        return result;
    }  
}
