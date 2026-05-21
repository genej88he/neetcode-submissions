class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0;
        int costTotal = 0;

        for (int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
        } 
        if (gasTotal < costTotal) {
            return -1;
        }
        gasTotal = 0;
        costTotal = 0;
        int times = 0;
        int size = gas.length;
        for (int i = 0; i <= size; i++) {
            gasTotal += gas[i % gas.length];
            costTotal += cost[i % gas.length];
            
            if (gasTotal < costTotal) {
                gasTotal = 0;
                costTotal = 0;
                size++;
                times = 0;
                continue;
            }
            if (times == gas.length) {
                return i % gas.length;
            }
            size++;
            times++;
        }
        return -1;

    }
}
