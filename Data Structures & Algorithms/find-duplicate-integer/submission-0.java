class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Step 2: Phase 1 - Find the collision point within the cycle
        do {
            slow = nums[slow];           // Move 1 jump
            fast = nums[nums[fast]];     // Move 2 jumps
        } while (slow != fast);

        // Step 3: Phase 2 - Find the entrance to the cycle (the duplicate)
        // Reset one pointer to the start
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];           // Both move 1 jump now
            fast = nums[fast];
        }

        // Both pointers meet at the entrance to the cycle
        return slow;
    }
}
