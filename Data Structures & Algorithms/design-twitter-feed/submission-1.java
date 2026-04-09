class Twitter {
    private HashMap<Integer, List<int[]>> tweetMap;
    private HashMap<Integer, Set<Integer>> followsMap;
    private int count;

    public Twitter() {
        this.tweetMap = new HashMap<>();
        this.followsMap = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        } 
        tweetMap.get(userId).add(new int[]{count, tweetId});
        count++;    
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        if (tweetMap.containsKey(userId)) {
            List<int[]> chose = tweetMap.get(userId);
            for (int[] each : chose) {
                maxHeap.add(each);
            }
        }
        
        if (followsMap.containsKey(userId)) {
            Set<Integer> chose = followsMap.get(userId);
            for (int each : chose) {
                if (tweetMap.containsKey(each)) {
                    List<int[]> followerTweet = tweetMap.get(each);
                    for (int[] eachPost : followerTweet) {
                        maxHeap.add(eachPost);
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int times = 0;
        while (!maxHeap.isEmpty() && times < 10) {
            result.add(maxHeap.remove()[1]);
            times++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            if (!followsMap.containsKey(followerId)) {
                followsMap.put(followerId, new HashSet<>());
            }
            followsMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followsMap.containsKey(followerId)) {
            Set<Integer> followees = followsMap.get(followerId);
            if (followees.contains(followeeId)) {
                for (int eachFollowee : followees) {
                    if (eachFollowee == followeeId) {
                        followees.remove(eachFollowee);
                    }
                }
            }
        }
    }
}
