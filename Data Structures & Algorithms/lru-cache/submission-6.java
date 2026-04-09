class ListNode {
    private int key;
    private int val;
    private ListNode prev;
    private ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail; // Connect head to tail
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            ListNode node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        add(newNode);
        if (map.size() > capacity) {
            // Remove the node right before tail (the LRU)
            ListNode lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    // Helper: Remove node from the middle of the line
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Add node right after the head (the "newest" spot)
    private void add(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
